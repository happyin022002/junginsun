<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0056GS.jsp
*@FileTitle :  Vessel Report
*Open Issues :
*Change history :
*@LastModifyDate : 2007-07-23
*@LastModifier : Jeong-Seon An , Yoon-Jung Lee
*@LastVersion : 1.0
* 2007-07-23 Jeong-Seon An , Yoon-Jung Lee
* 1.0 최초 생성
* 2007-08-31 우선주석처리 JSPUtil.getNull(rowSet.getString(PKUP_NO))
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.visibilitymanage.vesselreport.event.ESD_SCE_0056EventResponse" %>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler" %>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil" %>


  <!--조회된 내역-->
  <?xml version="1.0" ?>
  <SHEET>
    <DATA TOTAL="112">
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>B/L</TD>
        <TD>B/L</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>BKG</TD>
        <TD>BKG</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>NIS-COP\nUnmatch</TD>
        <TD>NIS-COP\nUnmatch</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>BKG</TD>
        <TD>POD</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>BKG</TD>
        <TD>DEL</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>COP</TD>
        <TD>POD</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>COP</TD>
        <TD>DEL</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Container</TD>
        <TD>Container</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>TY/SZ</TD>
        <TD>TY/SZ</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>MVMT</TD>
        <TD>MVMT</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Empty Notification</TD>
        <TD>Empty Notification</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>COP</TD>
        <TD>COP</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>DUP</TD>
        <TD>DUP</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>ST_Node</TD>
        <TD>ST_Node</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>ST_Date</TD>
        <TD>ST_Date</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>VVD</TD>
        <TD>VVD</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Lane</TD>
        <TD>Lane</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>ETA</TD>
        <TD>ETA</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>SPE</TD>
        <TD>SPE</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>POD</TD>
        <TD>POD</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Rail DEST</TD>
        <TD>Rail DEST</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>IT LOC</TD>
        <TD>IT LOC</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>CSTMS\nCLR LOC</TD>
        <TD>CSTMS\nCLR LOC</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>DEL</TD>
        <TD>DEL</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>EQ Office</TD>
        <TD>EQ Office</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Term</TD>
        <TD>Term</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>RL</TD>
        <TD>RL</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Add</TD>
        <TD>Add</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Rail Plan</TD>
        <TD>Rail Plan</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Rail1</TD>
        <TD>S/O</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Rail1</TD>
        <TD>S/O IRG</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Rail1</TD>
        <TD>S/O Date</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Rail1</TD>
        <TD>W/O</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Rail1</TD>
        <TD>W/O Date</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Rail1</TD>
        <TD>Rail Company</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Rail2</TD>
        <TD>S/O</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Rail2</TD>
        <TD>S/O IRG</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Rail2</TD>
        <TD>S/O Date</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Rail2</TD>
        <TD>W/O</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Rail2</TD>
        <TD>W/O Date</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Rail2</TD>
        <TD>Rail Company</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Truck(Door)\nPlan</TD>
        <TD>Truck(Door)\nPlan</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Truck (Door)</TD>
        <TD>S/O</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Truck (Door) </TD>
        <TD>S/O IRG</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Truck (Door)</TD>
        <TD>S/O Date</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Truck (Door)</TD>
        <TD>W/O</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Truck (Door)</TD>
        <TD>W/O Date</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Truck(Shuttle)\nPlan</TD>
        <TD>Truck(Shuttle)\nPlan</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Truck (Shuttle)</TD>
        <TD>S/O</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Truck (Shuttle)</TD>
        <TD>S/O IRG</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Truck (Shuttle)</TD>
        <TD>S/O Date</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Truck (Shuttle)</TD>
        <TD>W/O</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Truck (Shuttle)</TD>
        <TD>W/O Date</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Truck(Additional)\nPlan</TD>
        <TD>Truck(Additional)\nPlan</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Truck (Additional)</TD>
        <TD>S/O</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Truck (Additional)</TD>
        <TD>S/O IRG</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Truck (Additional)</TD>
        <TD>S/O Date</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Truck (Additional)</TD>
        <TD>W/O</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Truck (Additional)</TD>
        <TD>W/O Date</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Water\nPlan</TD>
        <TD>Water\nPlan</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Water</TD>
        <TD>S/O</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Water</TD>
        <TD>S/O IRG</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Water</TD>
        <TD>S/O Date</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Water</TD>
        <TD>W/O</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Water</TD>
        <TD>W/O Date</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>DR_WK</TD>
        <TD>DR_WK</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>DR_FM</TD>
        <TD>DR_FM</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>DR_TO</TD>
        <TD>DR_TO</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>DR_S/P</TD>
        <TD>DR_S/P</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>DR_S/P Name</TD>
        <TD>DR_S/P Name</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>DR_S/P TelNo.</TD>
        <TD>DR_S/P TelNo.</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>COP Status</TD>
        <TD>COP Status</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>From</TD>
        <TD>From</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Guide</TD>
        <TD>Guide</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>P/UP Node</TD>
        <TD>P/UP Node</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>AVL Date</TD>
        <TD>AVL Date</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Free Date</TD>
        <TD>Free Date</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>F</TD>
        <TD>F</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>O</TD>
        <TD>O</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>C</TD>
        <TD>C</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>CM</TD>
        <TD>CM</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>P/UP NO.</TD>
        <TD>P/UP NO.</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>P/UP Office</TD>
        <TD>P/UP Office</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>P/UP Notice</TD>
        <TD>P/UP Notice</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>P/UP End</TD>
        <TD>P/UP End</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>S/C NO.</TD>
        <TD>S/C NO.</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>CNEE</TD>
        <TD>CNEE</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>CNEE Address</TD>
        <TD>CNEE Address</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>CNFF FAX</TD>
        <TD>CNFF FAX</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>SHPR</TD>
        <TD>SHPR</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>SHPR Address</TD>
        <TD>SHPR Address</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>SHPR FAX</TD>
        <TD>SHPR FAX</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>NTFY</TD>
        <TD>NTFY</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>NTFY Address</TD>
        <TD>NTFY Address</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>NTFY FAX</TD>
        <TD>NTFY FAX</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>B/L Date</TD>
        <TD>B/L Date</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Filer</TD>
        <TD>Filer</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>IT NO.</TD>
        <TD>IT NO.</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>IT Date</TD>
        <TD>IT Date</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>PO NO.</TD>
        <TD>PO NO.</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Seal NO.</TD>
        <TD>Seal NO.</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Weight</TD>
        <TD>Weight</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Rail1</TD>
        <TD>CLM Status</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Rail1</TD>
        <TD>CLM Location</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Rail1</TD>
        <TD>ST</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Rail1</TD>
        <TD>CLM Date</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Rail2</TD>
        <TD>CLM Status</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Rail2</TD>
        <TD>CLM Location</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Rail2</TD>
        <TD>ST</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Rail2</TD>
        <TD>CLM Date</TD>
      </TR>
      <TR>
        <TD>1</TD>
        <TD></TD>
        <TD>Remark</TD>
        <TD>Remark</TD>
      </TR>
    </DATA>
  </SHEET>