/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.75
 * Generated at: 2023-08-18 20:17:22 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.xava;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.Locale;
import org.openxava.util.XavaResources;
import org.openxava.util.Primitives;
import org.openxava.util.Strings;
import org.openxava.util.Is;
import org.openxava.tab.meta.MetaTab;
import org.openxava.tab.Tab;
import org.openxava.component.MetaComponent;
import org.openxava.model.meta.MetaModel;
import org.openxava.model.meta.MetaProperty;
import org.openxava.util.XSystem;
import org.openxava.util.XavaPreferences;

public final class jasperReport_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {


private static int EXTRA_WIDTH = 15; 
private static int MAX_CHARACTERS_PER_ROW = 122;   // If you modify these
private static int WIDE_CHARACTERS_PER_ROW = 104; // values please verify
private static int MEDIUM_CHARACTERS_PER_ROW = 63; // if the tests in PrettyPrintingTest
private static int NARROW_CHARACTERS_PER_ROW = 44; // pass for the 4 branch of the if below

private int [] parseWidths(String widths, Integer columnCountLimit) { 
	String [] tokens = widths.split("[\\[\\], ]+");		
	int size = columnCountLimit == null?tokens.length - 1:columnCountLimit.intValue(); 
	int [] result = new int[size];
	for (int i=0; i<result.length; i++) {
		result[i] = Integer.parseInt(tokens[i+1]);
	}	
	return result;	
}

private int adjustWithsToLabels(List metaProperties, int [] widths, Locale locale) {  
	int totalWidth = 0;	
	int i=0;
	for (Iterator it = metaProperties.iterator(); it.hasNext(); i++) {
		MetaProperty p = (MetaProperty) it.next();
		String label = p.getQualifiedLabel(locale);  
		if (widths[i] == 0) widths[i] = p.getSize();
		int labelLength = Math.min(label.length(), 10); 
		if (widths[i] < labelLength) widths[i] = labelLength;
		totalWidth+=widths[i];		
	}
	return totalWidth;
}

private int calculateRowsInHeader(List metaProperties, int [] widths, Locale locale) { 	 	
	int rowsInHeader = 1;
	int i=0;
	for (Iterator it = metaProperties.iterator(); it.hasNext(); i++) {
		MetaProperty p = (MetaProperty) it.next();
		String label = p.getQualifiedLabel(locale); 
		int rows = (label.length() - 1) / (int) (widths[i] * 1.58) + 1; 
		rowsInHeader = Math.max(rowsInHeader, rows);	
	}
	return rowsInHeader;
}

private void expandWidths(List metaProperties, int [] widths, int max, Locale locale) { 
	int totalWidth = 0;
	Collection candidates = new java.util.ArrayList();
	for (int i=0; i<widths.length; i++) {
		if (widths[i] < ((MetaProperty) metaProperties.get(i)).getQualifiedLabel(locale).length()) {
			candidates.add(new Integer(i));
		}
		totalWidth += widths[i];
	}
	if (totalWidth < max && !candidates.isEmpty()) {
		int extra = (max - totalWidth) / candidates.size();
		for (Iterator it = candidates.iterator(); it.hasNext(); ) {
			int i = ((Integer) it.next()).intValue();
			widths[i] = widths[i] + extra;
		}
	}	
}

private int [] tightenWidths(List metaProperties, int [] widths) { 
	int [] originalWidths = widths.clone(); 
	int littleOnesTotal = 0;
	int littleOnesCount = 0;
	for (int i=0; i<widths.length; i++) {
		if (widths[i] <= 20) {
			littleOnesTotal+=widths[i];
			littleOnesCount++;
		}
	}	
	int spaceForBigOnes = MAX_CHARACTERS_PER_ROW - littleOnesTotal;
	int bigOnesCount = widths.length - littleOnesCount; 
	int widthForBig = bigOnesCount==0?20:spaceForBigOnes / bigOnesCount; 
	if (widthForBig < 20) widthForBig = 20;
	int total = 0; 
	for (int i=0; i<widths.length; i++) {
		if (widths[i] > 20 && widths[i] > widthForBig) widths[i] = widthForBig;
		total += widths[i];
	}		
	if (total > MAX_CHARACTERS_PER_ROW) {
		metaProperties.remove(metaProperties.size() - 1);
		widths = org.apache.commons.lang.ArrayUtils.remove(originalWidths, originalWidths.length - 1);
		return tightenWidths(metaProperties, widths);
	}
	return widths;
}

private String getAlign(MetaProperty p) throws Exception {
	String align = "Left";
	if (p.isNumber() && !p.hasValidValues()) align = "Right";
	else if (p.getType().equals(boolean.class)) align = "Center";
	return align;
}

private List getMetaProperties(Tab tab, Integer columnCountLimit) { 
	if (columnCountLimit == null) return new java.util.ArrayList(tab.getMetaProperties()); 
	List result = new java.util.ArrayList(); 
	int c = 0;
	for (MetaProperty p: tab.getMetaProperties()) {
		if (++c > columnCountLimit) break; 
		result.add(p);
	}
	return result;
}

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1683155358609L));
    _jspx_dependants.put("jar:file:/C:/Users/Rafael/Desktop/ProyectosLibres/PruebaPlusTech/PlusTech/target/PlusTech/WEB-INF/lib/jstl-1.2.jar!/META-INF/c-1_0.tld", Long.valueOf(1153403082000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("org.openxava.model.meta.MetaProperty");
    _jspx_imports_classes.add("org.openxava.tab.meta.MetaTab");
    _jspx_imports_classes.add("org.openxava.util.Primitives");
    _jspx_imports_classes.add("java.util.Iterator");
    _jspx_imports_classes.add("org.openxava.util.Strings");
    _jspx_imports_classes.add("org.openxava.util.XavaPreferences");
    _jspx_imports_classes.add("java.util.Collection");
    _jspx_imports_classes.add("java.util.HashMap");
    _jspx_imports_classes.add("org.openxava.util.Is");
    _jspx_imports_classes.add("org.openxava.util.XSystem");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("java.util.Locale");
    _jspx_imports_classes.add("java.util.Map");
    _jspx_imports_classes.add("org.openxava.util.XavaResources");
    _jspx_imports_classes.add("org.openxava.tab.Tab");
    _jspx_imports_classes.add("org.openxava.component.MetaComponent");
    _jspx_imports_classes.add("org.openxava.model.meta.MetaModel");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.print("<?xml version='1.0' encoding='" + org.openxava.util.XSystem.getEncoding() + "' ?>");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE jasperReport PUBLIC \"-//JasperReports//DTD Report Design//EN\" \n");
      out.write("\"http://jasperreports.sourceforge.net/dtds/jasperreport.dtd\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write(" \n");
      out.write(" \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write(" \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write('\n');
      out.write('\n');

Tab tab = (Tab) request.getSession().getAttribute("xava_reportTab");
String reportName = Strings.change(tab.getModelName(), ".", "_"); 
Collection totalProperties = tab.getTotalPropertiesNames();  		
String language = request.getParameter("language");
if (language == null) language = org.openxava.util.Locales.getCurrent().getDisplayLanguage();
language = language == null?request.getLocale().getDisplayLanguage():language;
Locale locale = new Locale(language, "");
String scolumnCountLimit = request.getParameter("columnCountLimit");
Integer columnCountLimit = scolumnCountLimit == null?null:Integer.parseInt(scolumnCountLimit);
List metaProperties = getMetaProperties(tab, columnCountLimit);
int columnsSeparation = 10;
int [] widths = parseWidths(request.getParameter("widths"), columnCountLimit); 
int totalWidth = adjustWithsToLabels(metaProperties, widths, locale); 
int letterWidth;
int letterSize;
int lineHeight; 
int pageWidth;
int pageHeight;
int columnWidth;
String orientation = null;

if (totalWidth > WIDE_CHARACTERS_PER_ROW) {
	if (totalWidth > MAX_CHARACTERS_PER_ROW) tightenWidths(metaProperties, widths);
	else expandWidths(metaProperties, widths, MAX_CHARACTERS_PER_ROW, locale); 
	orientation="Landscape";
	letterWidth = 4;
	letterSize = 7;
	lineHeight = 8; 
	pageWidth=842;
	pageHeight=595;
	columnWidth=780;	
}
else if (totalWidth > MEDIUM_CHARACTERS_PER_ROW) {
	expandWidths(metaProperties, widths, WIDE_CHARACTERS_PER_ROW, locale); 
	orientation="Landscape";
	letterWidth = 5;  
	letterSize=8;
	lineHeight = 10;
	pageWidth=842;
	pageHeight=595;
	columnWidth=780;	
} 
else if (totalWidth > NARROW_CHARACTERS_PER_ROW) {
	expandWidths(metaProperties, widths, MEDIUM_CHARACTERS_PER_ROW, locale); 
	orientation="Portrait";
	letterWidth = 5; 
	letterSize=8;
	lineHeight = 10;
	pageWidth=595;
	pageHeight=842;
	columnWidth=535;
}
else {
	expandWidths(metaProperties, widths, NARROW_CHARACTERS_PER_ROW, locale);
	orientation="Portrait";
	letterWidth = 10;
	letterSize = 12;
	lineHeight = 15;
	pageWidth=595;
	pageHeight=842;
	columnWidth=535;
}

int rowsInHeader = calculateRowsInHeader(metaProperties, widths, locale);

      out.write("\n");
      out.write("\n");
      out.write("<jasperReport\n");
      out.write("		 name=\"");
      out.print(reportName);
      out.write("\"\n");
      out.write("		 columnCount=\"1\"\n");
      out.write("		 printOrder=\"Vertical\"\n");
      out.write("		 orientation=\"");
      out.print(orientation);
      out.write("\"\n");
      out.write("		 pageWidth=\"");
      out.print(pageWidth);
      out.write("\"\n");
      out.write("		 pageHeight=\"");
      out.print(pageHeight);
      out.write("\"\n");
      out.write("		 columnWidth=\"");
      out.print(columnWidth);
      out.write("\"\n");
      out.write("		 columnSpacing=\"0\"\n");
      out.write("		 leftMargin=\"30\"\n");
      out.write("		 rightMargin=\"30\"\n");
      out.write("		 topMargin=\"20\"\n");
      out.write("		 bottomMargin=\"20\"\n");
      out.write("		 whenNoDataType=\"NoPages\"\n");
      out.write("		 isTitleNewPage=\"false\"\n");
      out.write("		 isSummaryNewPage=\"false\">		 \n");
      out.write("	");

	String fontName="DejaVu Sans";
	String pdfEncoding="Identity-H";
	
      out.write("	\n");
      out.write("	<reportFont name=\"Arial_Normal\" isDefault=\"true\" fontName=\"");
      out.print(fontName);
      out.write("\" size=\"8\" pdfFontName=\"");
      out.print(fontName);
      out.write("\" pdfEncoding=\"");
      out.print(pdfEncoding);
      out.write("\" isPdfEmbedded=\"true\"/>\n");
      out.write("	<reportFont name=\"Arial_Bold\" isDefault=\"false\" fontName=\"");
      out.print(fontName);
      out.write("\" size=\"8\" isBold=\"true\" pdfFontName=\"");
      out.print(fontName);
      out.write("\" pdfEncoding=\"");
      out.print(pdfEncoding);
      out.write("\" isPdfEmbedded=\"true\"/>\n");
      out.write("	<reportFont name=\"Arial_Italic\" isDefault=\"false\" fontName=\"");
      out.print(fontName);
      out.write("\" size=\"8\" isItalic=\"true\" pdfFontName=\"");
      out.print(fontName);
      out.write("\" pdfEncoding=\"");
      out.print(pdfEncoding);
      out.write("\" isPdfEmbedded=\"true\"/>	\n");
      out.write("\n");
      out.write("	<parameter name=\"Title\" class=\"java.lang.String\"/>	\n");
      out.write("	<parameter name=\"Organization\" class=\"java.lang.String\"/>\n");
      out.write("	<parameter name=\"Date\" class=\"java.lang.String\"/>\n");
      out.write("	");
	 
	for (Iterator it = metaProperties.iterator(); it.hasNext();) {
		MetaProperty p = (MetaProperty) it.next();				
		if (totalProperties.contains(p.getQualifiedName())) {				 
	
      out.write("\n");
      out.write("	<parameter name=\"");
      out.print(p.getQualifiedName());
      out.write("__TOTAL__\" class=\"java.lang.String\"/> 	\n");
      out.write("	");

		}
	}
	
      out.write("	\n");
      out.write("		\n");
      out.write("	");
		 
	int detailHeight = lineHeight; 
	for (Iterator it = metaProperties.iterator(); it.hasNext();) {
		MetaProperty p = (MetaProperty) it.next();
		String type = "java.lang.String";
		if (p.isCompatibleWith(byte[].class)) {
			type = "java.io.InputStream"; 
			detailHeight = 32;
		}
	
      out.write("\n");
      out.write("	<field name=\"");
      out.print(Strings.change(p.getQualifiedName(), ".", "_"));
      out.write("\" class=\"");
      out.print(type);
      out.write("\"/>\n");
      out.write("	");

	}
	
      out.write("	\n");
      out.write("		<background>\n");
      out.write("			<band height=\"0\"  isSplitAllowed=\"true\" >\n");
      out.write("			</band>\n");
      out.write("		</background>\n");
      out.write("		<title>\n");
      out.write("			<band height=\"25\"  isSplitAllowed=\"true\" >\n");
      out.write("\n");
      out.write("				<textField>\n");
      out.write("					<reportElement\n");
      out.write("						mode=\"Transparent\"\n");
      out.write("						x=\"0\"\n");
      out.write("						y=\"0\"\n");
      out.write("						width=\"200\"\n");
      out.write("						height=\"25\"\n");
      out.write("						forecolor=\"#000000\"\n");
      out.write("						backcolor=\"#FFFFFF\"\n");
      out.write("						positionType=\"FixRelativeToTop\"\n");
      out.write("						isPrintRepeatedValues=\"true\"\n");
      out.write("						isRemoveLineWhenBlank=\"false\"\n");
      out.write("						isPrintInFirstWholeBand=\"false\"\n");
      out.write("						isPrintWhenDetailOverflows=\"false\"/>\n");
      out.write("					<textElement textAlignment=\"Left\" verticalAlignment=\"Top\" lineSpacing=\"Single\">\n");
      out.write("						<font reportFont=\"Arial_Normal\" size=\"8\"/>\n");
      out.write("					</textElement>\n");
      out.write("					<textFieldExpression class=\"java.lang.String\">$P{Organization}</textFieldExpression>					\n");
      out.write("				</textField>\n");
      out.write("						\n");
      out.write("				<textField>\n");
      out.write("					<reportElement\n");
      out.write("						mode=\"Transparent\"\n");
      out.write("						x=\"5\"\n");
      out.write("						y=\"5\"\n");
      out.write("						width=\"");
      out.print(columnWidth);
      out.write("\"\n");
      out.write("						height=\"20\"\n");
      out.write("						forecolor=\"#000000\"\n");
      out.write("						backcolor=\"#FFFFFF\"\n");
      out.write("						positionType=\"FixRelativeToTop\"\n");
      out.write("						isPrintRepeatedValues=\"true\"\n");
      out.write("						isRemoveLineWhenBlank=\"false\"\n");
      out.write("						isPrintInFirstWholeBand=\"false\"\n");
      out.write("						isPrintWhenDetailOverflows=\"false\"/>\n");
      out.write("					<textElement textAlignment=\"Center\" verticalAlignment=\"Top\" lineSpacing=\"Single\">\n");
      out.write("						<font reportFont=\"Arial_Normal\" size=\"15\"/>\n");
      out.write("					</textElement>\n");
      out.write("					<textFieldExpression class=\"java.lang.String\">$P{Title}</textFieldExpression>					\n");
      out.write("				</textField>\n");
      out.write("				\n");
      out.write("\n");
      out.write("				<line direction=\"TopDown\">\n");
      out.write("					<reportElement\n");
      out.write("						mode=\"Opaque\"\n");
      out.write("						x=\"0\"\n");
      out.write("						y=\"23\"\n");
      out.write("						width=\"");
      out.print(columnWidth);
      out.write("\"\n");
      out.write("						height=\"0\"\n");
      out.write("						forecolor=\"#000000\"\n");
      out.write("						backcolor=\"#FFFFFF\"\n");
      out.write("						positionType=\"FixRelativeToTop\"\n");
      out.write("						isPrintRepeatedValues=\"true\"\n");
      out.write("						isRemoveLineWhenBlank=\"false\"\n");
      out.write("						isPrintInFirstWholeBand=\"false\"\n");
      out.write("						isPrintWhenDetailOverflows=\"false\"/>\n");
      out.write("					<graphicElement stretchType=\"NoStretch\" pen=\"1Point\" fill=\"Solid\" />\n");
      out.write("				</line>\n");
      out.write("\n");
      out.write("				<!-- Top line\n");
      out.write("				<line direction=\"TopDown\">\n");
      out.write("					<reportElement\n");
      out.write("						mode=\"Opaque\"\n");
      out.write("						x=\"0\"\n");
      out.write("						y=\"3\"\n");
      out.write("						width=\"");
      out.print(columnWidth);
      out.write("\"\n");
      out.write("						height=\"0\"\n");
      out.write("						forecolor=\"#000000\"\n");
      out.write("						backcolor=\"#FFFFFF\"\n");
      out.write("						positionType=\"FixRelativeToTop\"\n");
      out.write("						isPrintRepeatedValues=\"true\"\n");
      out.write("						isRemoveLineWhenBlank=\"false\"\n");
      out.write("						isPrintInFirstWholeBand=\"false\"\n");
      out.write("						isPrintWhenDetailOverflows=\"false\"/>\n");
      out.write("					<graphicElement stretchType=\"NoStretch\" pen=\"1Point\" fill=\"Solid\" />\n");
      out.write("				</line>\n");
      out.write("				-->\n");
      out.write("			</band>\n");
      out.write("		</title>\n");
      out.write("		<pageHeader>\n");
      out.write("			<band height=\"9\"  isSplitAllowed=\"true\" >\n");
      out.write("			</band>\n");
      out.write("		</pageHeader>\n");
      out.write("		");
 
		int headerHeight = rowsInHeader * lineHeight + 8; 
		
      out.write("\n");
      out.write("		<columnHeader>\n");
      out.write("			<band height=\"");
      out.print(headerHeight);
      out.write("\" isSplitAllowed=\"true\" >\n");
      out.write("				<rectangle radius=\"0\" >\n");
      out.write("					<reportElement\n");
      out.write("						mode=\"Opaque\"\n");
      out.write("						x=\"0\"\n");
      out.write("						y=\"0\"\n");
      out.write("						width=\"");
      out.print(columnWidth);
      out.write("\"\n");
      out.write("						height=\"");
      out.print(headerHeight - 5);
      out.write("\"\n");
      out.write("						forecolor=\"#000000\"\n");
      out.write("						backcolor=\"#808080\"\n");
      out.write("						positionType=\"FixRelativeToTop\"\n");
      out.write("						isPrintRepeatedValues=\"true\"\n");
      out.write("						isRemoveLineWhenBlank=\"false\"\n");
      out.write("						isPrintInFirstWholeBand=\"false\"\n");
      out.write("						isPrintWhenDetailOverflows=\"false\"/>\n");
      out.write("					<graphicElement stretchType=\"NoStretch\" pen=\"None\" fill=\"Solid\" />\n");
      out.write("				</rectangle>\n");
      out.write("				<line direction=\"BottomUp\">\n");
      out.write("					<reportElement\n");
      out.write("						mode=\"Opaque\"\n");
      out.write("						x=\"0\"\n");
      out.write("						y=\"0\"\n");
      out.write("						width=\"");
      out.print(columnWidth);
      out.write("\"\n");
      out.write("						height=\"0\"\n");
      out.write("						forecolor=\"#000000\"\n");
      out.write("						backcolor=\"#FFFFFF\"\n");
      out.write("						positionType=\"FixRelativeToTop\"\n");
      out.write("						isPrintRepeatedValues=\"true\"\n");
      out.write("						isRemoveLineWhenBlank=\"false\"\n");
      out.write("						isPrintInFirstWholeBand=\"false\"\n");
      out.write("						isPrintWhenDetailOverflows=\"false\"/>\n");
      out.write("					<graphicElement stretchType=\"NoStretch\" pen=\"Thin\" fill=\"Solid\" />\n");
      out.write("				</line>\n");
      out.write("				<line direction=\"BottomUp\">\n");
      out.write("					<reportElement\n");
      out.write("						mode=\"Opaque\"\n");
      out.write("						x=\"0\"\n");
      out.write("						y=\"");
      out.print(headerHeight - 6);
      out.write("\"\n");
      out.write("						width=\"");
      out.print(columnWidth);
      out.write("\"\n");
      out.write("						height=\"0\"\n");
      out.write("						forecolor=\"#000000\"\n");
      out.write("						backcolor=\"#FFFFFF\"\n");
      out.write("						positionType=\"FixRelativeToTop\"\n");
      out.write("						isPrintRepeatedValues=\"true\"\n");
      out.write("						isRemoveLineWhenBlank=\"false\"\n");
      out.write("						isPrintInFirstWholeBand=\"false\"\n");
      out.write("						isPrintWhenDetailOverflows=\"false\"/>\n");
      out.write("					<graphicElement stretchType=\"NoStretch\" pen=\"Thin\" fill=\"Solid\" />\n");
      out.write("				</line>\n");
 
int x = 0;
int i = 0;
for (Iterator it = metaProperties.iterator(); it.hasNext(); i++) {			
	MetaProperty p = (MetaProperty) it.next();
	int width=widths[i]*letterWidth + EXTRA_WIDTH; 		

      out.write("\n");
      out.write("				<staticText>\n");
      out.write("					<reportElement\n");
      out.write("						mode=\"Transparent\"\n");
      out.write("						x=\"");
      out.print(x);
      out.write("\"\n");
      out.write("						y=\"2\"\n");
      out.write("						width=\"");
      out.print(width);
      out.write("\"\n");
      out.write("						height=\"");
      out.print(headerHeight-2);
      out.write("\"\n");
      out.write("						forecolor=\"#FFFFFF\"\n");
      out.write("						backcolor=\"#FFFFFF\"\n");
      out.write("						positionType=\"FixRelativeToTop\"\n");
      out.write("						isPrintRepeatedValues=\"true\"\n");
      out.write("						isRemoveLineWhenBlank=\"false\"\n");
      out.write("						isPrintInFirstWholeBand=\"true\"\n");
      out.write("						isPrintWhenDetailOverflows=\"true\"/>\n");
      out.write("					<textElement textAlignment=\"");
      out.print(getAlign(p));
      out.write("\" verticalAlignment=\"Top\" lineSpacing=\"Single\">\n");
      out.write("						<font reportFont=\"Arial_Normal\" size=\"");
      out.print(letterSize);
      out.write("\"/>\n");
      out.write("					</textElement>\n");
      out.write("					");
 String label = "<![CDATA[" + p.getQualifiedLabel(locale) + "]]>"; 
      out.write("\n");
      out.write("					<text>");
      out.print(label);
      out.write("</text>					\n");
      out.write("				</staticText>\n");

	x+=(width+columnsSeparation);
}

      out.write("				\n");
      out.write("			</band>\n");
      out.write("		</columnHeader>\n");
      out.write("		\n");
      out.write("		<detail>\n");
      out.write("			<band height=\"");
      out.print(detailHeight + 2);
      out.write("\"  isSplitAllowed=\"true\" >\n");
      out.write("				<line direction=\"TopDown\">\n");
      out.write("					<reportElement\n");
      out.write("						mode=\"Opaque\"\n");
      out.write("						x=\"0\"\n");
      out.write("						y=\"0\" \n");
      out.write("						width=\"");
      out.print(columnWidth);
      out.write("\"\n");
      out.write("						height=\"0\"\n");
      out.write("						forecolor=\"#808080\"\n");
      out.write("						backcolor=\"#FFFFFF\"\n");
      out.write("						positionType=\"Float\"\n");
      out.write("						isPrintRepeatedValues=\"true\"\n");
      out.write("						isRemoveLineWhenBlank=\"false\"\n");
      out.write("						isPrintInFirstWholeBand=\"false\"\n");
      out.write("						isPrintWhenDetailOverflows=\"true\"/>					\n");
      out.write("					<graphicElement stretchType=\"NoStretch\" pen=\"Thin\" fill=\"Solid\" />\n");
      out.write("				</line>\n");
 
x = 0;
i = 0;
for (Iterator it = metaProperties.iterator(); it.hasNext(); i++) {			
	MetaProperty p = (MetaProperty) it.next();	
	int width=widths[i]*letterWidth + EXTRA_WIDTH;
	if (p.isCompatibleWith(byte[].class)) { 

      out.write("	\n");
      out.write("				<image onErrorType=\"Blank\">\n");
      out.write("    				<reportElement x=\"");
      out.print(x);
      out.write("\" y=\"2\" width=\"");
      out.print(width);
      out.write("\" height=\"30\"/>\n");
      out.write("    				<imageExpression>$F{");
      out.print(Strings.change(p.getQualifiedName(), ".", "_"));
      out.write("}</imageExpression>\n");
      out.write("				</image>	\n");

	}
	else {

      out.write("								\n");
      out.write("				<textField isStretchWithOverflow=\"true\" pattern=\"\" isBlankWhenNull=\"true\" evaluationTime=\"Now\" hyperlinkType=\"None\" >\n");
      out.write("					<reportElement\n");
      out.write("						mode=\"Transparent\"\n");
      out.write("						x=\"");
      out.print(x);
      out.write("\"\n");
      out.write("						y=\"2\"\n");
      out.write("						width=\"");
      out.print(width);
      out.write("\"\n");
      out.write("						height=\"");
      out.print(detailHeight);
      out.write("\"\n");
      out.write("						forecolor=\"#000000\"\n");
      out.write("						backcolor=\"#FFFFFF\"\n");
      out.write("						positionType=\"FixRelativeToTop\"\n");
      out.write("						isPrintRepeatedValues=\"true\"\n");
      out.write("						isRemoveLineWhenBlank=\"false\"\n");
      out.write("						isPrintInFirstWholeBand=\"false\"\n");
      out.write("						isPrintWhenDetailOverflows=\"false\"/>\n");
      out.write("					<textElement textAlignment=\"");
      out.print(getAlign(p));
      out.write("\" verticalAlignment=\"Top\" lineSpacing=\"Single\">\n");
      out.write("						<font reportFont=\"Arial_Normal\" size=\"");
      out.print(letterSize);
      out.write("\"/>\n");
      out.write("					</textElement>\n");
      out.write("					<textFieldExpression class=\"java.lang.String\">$F{");
      out.print(Strings.change(p.getQualifiedName(), ".", "_"));
      out.write("}</textFieldExpression>\n");
      out.write("				</textField>\n");

	} 
	x+=(width+columnsSeparation);
}

      out.write("				\n");
      out.write("			</band>\n");
      out.write("		</detail>\n");
      out.write("		<pageFooter>\n");
      out.write("			<band height=\"27\"  isSplitAllowed=\"true\" >\n");
      out.write("				<textField isStretchWithOverflow=\"false\" pattern=\"\" isBlankWhenNull=\"false\" evaluationTime=\"Now\" hyperlinkType=\"None\" >					<reportElement\n");
      out.write("						mode=\"Transparent\"\n");
      out.write("						x=\"");
      out.print(columnWidth - 210);
      out.write("\"\n");
      out.write("						y=\"4\"\n");
      out.write("						width=\"174\"\n");
      out.write("						height=\"19\"\n");
      out.write("						forecolor=\"#000000\"\n");
      out.write("						backcolor=\"#FFFFFF\"\n");
      out.write("						positionType=\"FixRelativeToTop\"\n");
      out.write("						isPrintRepeatedValues=\"true\"\n");
      out.write("						isRemoveLineWhenBlank=\"false\"\n");
      out.write("						isPrintInFirstWholeBand=\"false\"\n");
      out.write("						isPrintWhenDetailOverflows=\"false\"/>\n");
      out.write("					<textElement textAlignment=\"Right\" verticalAlignment=\"Top\" lineSpacing=\"Single\">\n");
      out.write("						<font reportFont=\"Arial_Normal\" size=\"10\"/>\n");
      out.write("					</textElement>\n");
      out.write("				");

				String iniPageLabel = "<![CDATA[\"" + XavaResources.getString(request, "page") + " \"";
				String endPageLabel = " \" " + XavaResources.getString("of") + " \"]]>";
				
      out.write("\n");
      out.write("				<textFieldExpression class=\"java.lang.String\">");
      out.print(iniPageLabel);
      out.write(" + $V{PAGE_NUMBER} + ");
      out.print(endPageLabel);
      out.write("</textFieldExpression>\n");
      out.write("				</textField>\n");
      out.write("				<textField isStretchWithOverflow=\"false\" pattern=\"\" isBlankWhenNull=\"false\" evaluationTime=\"Report\" hyperlinkType=\"None\" >					<reportElement\n");
      out.write("						mode=\"Transparent\"\n");
      out.write("						x=\"");
      out.print(columnWidth - 36);
      out.write("\"\n");
      out.write("						y=\"4\"\n");
      out.write("						width=\"36\"\n");
      out.write("						height=\"19\"\n");
      out.write("						forecolor=\"#000000\"\n");
      out.write("						backcolor=\"#FFFFFF\"\n");
      out.write("						positionType=\"FixRelativeToTop\"\n");
      out.write("						isPrintRepeatedValues=\"true\"\n");
      out.write("						isRemoveLineWhenBlank=\"false\"\n");
      out.write("						isPrintInFirstWholeBand=\"false\"\n");
      out.write("						isPrintWhenDetailOverflows=\"false\"/>\n");
      out.write("					<textElement textAlignment=\"Left\" verticalAlignment=\"Top\" lineSpacing=\"Single\">\n");
      out.write("						<font reportFont=\"Arial_Normal\" size=\"10\" />\n");
      out.write("					</textElement>\n");
      out.write("				<textFieldExpression   class=\"java.lang.String\"><![CDATA[\" \" + $V{PAGE_NUMBER}]]></textFieldExpression>\n");
      out.write("				</textField>\n");
      out.write("				<line direction=\"TopDown\">\n");
      out.write("					<reportElement\n");
      out.write("						mode=\"Opaque\"\n");
      out.write("						x=\"0\"\n");
      out.write("						y=\"1\"\n");
      out.write("						width=\"");
      out.print(columnWidth);
      out.write("\"\n");
      out.write("						height=\"0\"\n");
      out.write("						forecolor=\"#000000\"\n");
      out.write("						backcolor=\"#FFFFFF\"\n");
      out.write("						positionType=\"FixRelativeToTop\"\n");
      out.write("						isPrintRepeatedValues=\"true\"\n");
      out.write("						isRemoveLineWhenBlank=\"false\"\n");
      out.write("						isPrintInFirstWholeBand=\"false\"\n");
      out.write("						isPrintWhenDetailOverflows=\"false\"/>\n");
      out.write("					<graphicElement stretchType=\"NoStretch\" pen=\"2Point\" fill=\"Solid\" />\n");
      out.write("				</line>\n");
      out.write("				<textField isStretchWithOverflow=\"false\" pattern=\"\" isBlankWhenNull=\"false\" evaluationTime=\"Now\" hyperlinkType=\"None\" >					<reportElement\n");
      out.write("						mode=\"Transparent\"\n");
      out.write("						x=\"1\"\n");
      out.write("						y=\"6\"\n");
      out.write("						width=\"209\"\n");
      out.write("						height=\"19\"\n");
      out.write("						forecolor=\"#000000\"\n");
      out.write("						backcolor=\"#FFFFFF\"\n");
      out.write("						positionType=\"FixRelativeToTop\"\n");
      out.write("						isPrintRepeatedValues=\"true\"\n");
      out.write("						isRemoveLineWhenBlank=\"false\"\n");
      out.write("						isPrintInFirstWholeBand=\"false\"\n");
      out.write("						isPrintWhenDetailOverflows=\"false\"/>\n");
      out.write("					<textElement textAlignment=\"Left\" verticalAlignment=\"Top\" lineSpacing=\"Single\">\n");
      out.write("						<font reportFont=\"Arial_Normal\" size=\"10\"/>\n");
      out.write("					</textElement>\n");
      out.write("				<textFieldExpression   class=\"java.lang.String\">\n");
      out.write("					<![CDATA[$P{Date}]]>\n");
      out.write("				</textFieldExpression>\n");
      out.write("				</textField>\n");
      out.write("			</band>\n");
      out.write("		</pageFooter>\n");
      out.write("		<summary>\n");
      out.write("			<band height=\"19\" isSplitAllowed=\"true\" >\n");
      out.write("				<line direction=\"TopDown\">\n");
      out.write("					<reportElement\n");
      out.write("						mode=\"Opaque\"\n");
      out.write("						x=\"0\"\n");
      out.write("						y=\"0\" \n");
      out.write("						width=\"");
      out.print(columnWidth);
      out.write("\"\n");
      out.write("						height=\"0\"\n");
      out.write("						forecolor=\"#808080\"\n");
      out.write("						backcolor=\"#FFFFFF\"\n");
      out.write("						positionType=\"Float\"\n");
      out.write("						isPrintRepeatedValues=\"true\"\n");
      out.write("						isRemoveLineWhenBlank=\"false\"\n");
      out.write("						isPrintInFirstWholeBand=\"false\"\n");
      out.write("						isPrintWhenDetailOverflows=\"true\"/>					\n");
      out.write("					<graphicElement stretchType=\"NoStretch\" pen=\"Thin\" fill=\"Solid\" />\n");
      out.write("				</line>\n");
 
x = 0;
i = 0;
for (Iterator it = metaProperties.iterator(); it.hasNext(); i++) {			
	MetaProperty p = (MetaProperty) it.next();	
	int width=widths[i]*letterWidth + EXTRA_WIDTH;
	if (totalProperties.contains(p.getQualifiedName())) { 

      out.write("								\n");
      out.write("				<textField isStretchWithOverflow=\"true\" pattern=\"\" isBlankWhenNull=\"true\" evaluationTime=\"Now\" hyperlinkType=\"None\" >					<reportElement\n");
      out.write("						mode=\"Transparent\"\n");
      out.write("						x=\"");
      out.print(x);
      out.write("\"\n");
      out.write("						y=\"2\"\n");
      out.write("						width=\"");
      out.print(width);
      out.write("\"\n");
      out.write("						height=\"");
      out.print(lineHeight);
      out.write("\"\n");
      out.write("						forecolor=\"#000000\"\n");
      out.write("						backcolor=\"#FFFFFF\"\n");
      out.write("						positionType=\"FixRelativeToTop\"\n");
      out.write("						isPrintRepeatedValues=\"true\"\n");
      out.write("						isRemoveLineWhenBlank=\"false\"\n");
      out.write("						isPrintInFirstWholeBand=\"false\"\n");
      out.write("						isPrintWhenDetailOverflows=\"false\"/>\n");
      out.write("					<textElement textAlignment=\"");
      out.print(getAlign(p));
      out.write("\" verticalAlignment=\"Top\" lineSpacing=\"Single\">\n");
      out.write("						<font reportFont=\"Arial_Bold\" size=\"");
      out.print(letterSize);
      out.write("\"/>\n");
      out.write("					</textElement>\n");
      out.write("					<textFieldExpression class=\"java.lang.String\">$P{");
      out.print(p.getQualifiedName());
      out.write("__TOTAL__}</textFieldExpression>\n");
      out.write("				</textField>\n");

	} 			
	x+=(width+columnsSeparation);
}

      out.write("					\n");
      out.write("			</band>\n");
      out.write("		</summary>\n");
      out.write("</jasperReport>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
