/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SCProposalMainDBDAOChkRouteListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAOChkRouteListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * * 2014.04.17 전윤주 [CHM-201429927] 미주 지역 4개 ECC 폐쇄 관련 S/C 해당 운임 Block 기능 개발
	  *   TPE Scope S/C에 특정 지역이 있는지 확인한다.
	  * * 2014.05.02 전윤주 [CHM-201430105] CY와 Door term 에 따라 D.VIA 체크로직을 분기하여 추가
	  * * 2015.04.28 송호진 [CHM-201535631] 43 SDD Close 관련 S/C system block 요청 - message 변경 ( PRI01153 )
	  * * 2016.01.20 현성길 [CHM-201639894] System Block 해제_USPOA 
	  * * 2016.01.22 현성길 [CHM-201639924] System Block 해제_USOSH
	  * * 2016.01.22 현성길 [CHM-201640091] 43 SDD Close 관련 S/C system block 요청-43개 SDD 지역 모두 Block 철회
	  * * 2016.05.09 현성길 [CHM-201641548] 4개 ECC 지역 Door Location 및 USOMA(CY) Block 해제 및 Cntr Type "A5"추가
	  * * 2016.06.15 현성길 [CHM-201642143] USAMA(DR) 지역 Block 철회
	  * </pre>
	  */
	public SCProposalMainDBDAOChkRouteListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAOChkRouteListRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT DISTINCT A3.LOC_CD ETC1" ).append("\n"); 
		query.append("    FROM PRI_SP_SCP_RT_ROUT_PNT A1" ).append("\n"); 
		query.append("        ,PRI_SP_SCP_GRP_LOC A2" ).append("\n"); 
		query.append("        ,PRI_SP_SCP_GRP_LOC_DTL A3" ).append("\n"); 
		query.append("        ,MDM_LOCATION A4" ).append("\n"); 
		query.append("        ,MDM_EQ_ORZ_CHT A5" ).append("\n"); 
		query.append("        ,PRI_SP_MN A6" ).append("\n"); 
		query.append("        ,PRI_SP_SCP_RT_ROUT_VIA A7" ).append("\n"); 
		query.append("   WHERE A1.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("     AND A1.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("     AND A1.SVC_SCP_CD = 'TPE' --TPE Scope????? check" ).append("\n"); 
		query.append("     AND A1.ORG_DEST_TP_CD = 'D' -- Destination????? check" ).append("\n"); 
		query.append("     AND A1.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("     AND A1.ROUT_PNT_LOC_TP_CD = 'G' --Group location ????? ????????????" ).append("\n"); 
		query.append("     AND A1.ROUT_PNT_LOC_DEF_CD = A2.PRC_GRP_LOC_CD" ).append("\n"); 
		query.append("     AND A1.PROP_NO = A2.PROP_NO" ).append("\n"); 
		query.append("     AND A1.AMDT_SEQ = A2.AMDT_SEQ" ).append("\n"); 
		query.append("     AND A1.SVC_SCP_CD = A2.SVC_SCP_CD" ).append("\n"); 
		query.append("     AND A2.PROP_NO = A3.PROP_NO" ).append("\n"); 
		query.append("     AND A2.AMDT_SEQ = A3.AMDT_SEQ" ).append("\n"); 
		query.append("     AND A2.SVC_SCP_CD = A3.SVC_SCP_CD" ).append("\n"); 
		query.append("     AND A2.GRP_LOC_SEQ  = A3.GRP_LOC_SEQ" ).append("\n"); 
		query.append("     AND A3.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("     AND A3.LOC_CD = A4.LOC_CD" ).append("\n"); 
		query.append("     AND A4.SCC_CD = A5.SCC_CD" ).append("\n"); 
		query.append("     AND A1.PROP_NO = A7.PROP_NO" ).append("\n"); 
		query.append("     AND A1.AMDT_SEQ = A7.AMDT_SEQ" ).append("\n"); 
		query.append("     AND A1.SVC_SCP_CD = A7.SVC_SCP_CD" ).append("\n"); 
		query.append("     AND A1.GEN_SPCL_RT_TP_CD = A7.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("     AND A1.CMDT_HDR_SEQ = A7.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("     AND A1.ROUT_SEQ = A7.ROUT_SEQ" ).append("\n"); 
		query.append("     AND A1.ORG_DEST_TP_CD = A7.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("     AND A7.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("	 AND A3.LOC_CD IN ('USHAR', 'USBUF', 'USPIT', 'USMOB', 'USJAN') -- 6????? Location ???????????? Door ???????????? block" ).append("\n"); 
		query.append("     AND A1.RCV_DE_TERM_CD = 'D'" ).append("\n"); 
		query.append("     AND A1.PROP_NO = A6.PROP_NO" ).append("\n"); 
		query.append("     AND A1.AMDT_SEQ = A6.AMDT_SEQ" ).append("\n"); 
		query.append("     AND A6.EXP_DT >= TO_DATE('20140501', 'YYYYMMDD') -- 2014/05/01 ???????????? ????????????????????????? ????????????" ).append("\n"); 
		query.append("     AND( " ).append("\n"); 
		query.append("        ( A7.ROUT_VIA_PORT_TP_CD = 'G' AND A7.ROUT_VIA_PORT_DEF_CD IN (" ).append("\n"); 
		query.append("                                                                        SELECT GL.PRC_GRP_LOC_CD" ).append("\n"); 
		query.append("                                                                        FROM PRI_SP_SCP_GRP_LOC GL ," ).append("\n"); 
		query.append("                                                                          PRI_SP_SCP_GRP_LOC_DTL GD" ).append("\n"); 
		query.append("                                                                        WHERE GD.PROP_NO = GL.PROP_NO" ).append("\n"); 
		query.append("                                                                          AND GD.AMDT_SEQ = GL.AMDT_SEQ" ).append("\n"); 
		query.append("                                                                          AND GD.SVC_SCP_CD = GL.SVC_SCP_CD" ).append("\n"); 
		query.append("                                                                          AND GD.GRP_LOC_SEQ = GL.GRP_LOC_SEQ" ).append("\n"); 
		query.append("                                                                          AND GL.PROP_NO = A7.PROP_NO" ).append("\n"); 
		query.append("                                                                          AND GL.AMDT_SEQ = A7.AMDT_SEQ" ).append("\n"); 
		query.append("                                                                          AND GL.SVC_SCP_CD = A7.SVC_SCP_CD" ).append("\n"); 
		query.append("                                                                          AND GD.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                                                                          AND GD.LOC_CD IN ('USLGB', 'USLAX', 'USOAK', 'USSFO', 'USPDX', 'USSEA', 'USTIW', 'CAPRR', 'CAVAN') " ).append("\n"); 
		query.append("                                                                        )" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("       OR (A7.ROUT_VIA_PORT_TP_CD <> 'G' AND A7.ROUT_VIA_PORT_DEF_CD IN ('USLGB', 'USLAX', 'USOAK', 'USSFO', 'USPDX', 'USSEA', 'USTIW', 'CAPRR', 'CAVAN'))" ).append("\n"); 
		query.append("       )--D.VIA????? 9????? location????? ????????????????? ?????????????????" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("   SELECT DISTINCT A1.ROUT_PNT_LOC_DEF_CD ETC1" ).append("\n"); 
		query.append("    FROM PRI_SP_SCP_RT_ROUT_PNT A1" ).append("\n"); 
		query.append("        ,MDM_LOCATION A2" ).append("\n"); 
		query.append("        ,MDM_EQ_ORZ_CHT A3" ).append("\n"); 
		query.append("        ,PRI_SP_MN A4" ).append("\n"); 
		query.append("        ,PRI_SP_SCP_RT_ROUT_VIA A5 " ).append("\n"); 
		query.append("   WHERE A1.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("     AND A1.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("     AND A1.SVC_SCP_CD = 'TPE' --TPE Scope????? check" ).append("\n"); 
		query.append("     AND A1.ORG_DEST_TP_CD = 'D' -- Destination????? check" ).append("\n"); 
		query.append("     AND A1.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("     AND A1.ROUT_PNT_LOC_TP_CD = 'L' --Location ????? ????????????" ).append("\n"); 
		query.append("     AND A1.ROUT_PNT_LOC_DEF_CD = A2.LOC_CD" ).append("\n"); 
		query.append("     AND A2.SCC_CD = A3.SCC_CD" ).append("\n"); 
		query.append("     AND A1.PROP_NO = A5.PROP_NO" ).append("\n"); 
		query.append("     AND A1.AMDT_SEQ = A5.AMDT_SEQ" ).append("\n"); 
		query.append("     AND A1.SVC_SCP_CD = A5.SVC_SCP_CD" ).append("\n"); 
		query.append("     AND A1.GEN_SPCL_RT_TP_CD = A5.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("     AND A1.CMDT_HDR_SEQ = A5.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("     AND A1.ROUT_SEQ = A5.ROUT_SEQ" ).append("\n"); 
		query.append("     AND A1.ORG_DEST_TP_CD = A5.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("     AND A5.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("     AND A1.ROUT_PNT_LOC_DEF_CD IN ('USHAR', 'USBUF', 'USPIT', 'USMOB', 'USJAN')  -- 6????? Location ???????????? Door ???????????? block" ).append("\n"); 
		query.append("     AND A1.RCV_DE_TERM_CD = 'D'" ).append("\n"); 
		query.append("     AND A1.PROP_NO = A4.PROP_NO" ).append("\n"); 
		query.append("     AND A1.AMDT_SEQ = A4.AMDT_SEQ" ).append("\n"); 
		query.append("     AND A4.EXP_DT >= TO_DATE('20140501', 'YYYYMMDD') -- 2014/05/01 ???????????? ????????????????????????? ????????????" ).append("\n"); 
		query.append("     AND( " ).append("\n"); 
		query.append("        ( A5.ROUT_VIA_PORT_TP_CD = 'G' AND A5.ROUT_VIA_PORT_DEF_CD IN (" ).append("\n"); 
		query.append("                                                                        SELECT GL.PRC_GRP_LOC_CD" ).append("\n"); 
		query.append("                                                                        FROM PRI_SP_SCP_GRP_LOC GL ," ).append("\n"); 
		query.append("                                                                          PRI_SP_SCP_GRP_LOC_DTL GD" ).append("\n"); 
		query.append("                                                                        WHERE GD.PROP_NO = GL.PROP_NO" ).append("\n"); 
		query.append("                                                                          AND GD.AMDT_SEQ = GL.AMDT_SEQ" ).append("\n"); 
		query.append("                                                                          AND GD.SVC_SCP_CD = GL.SVC_SCP_CD" ).append("\n"); 
		query.append("                                                                          AND GD.GRP_LOC_SEQ = GL.GRP_LOC_SEQ" ).append("\n"); 
		query.append("                                                                          AND GL.PROP_NO = A5.PROP_NO" ).append("\n"); 
		query.append("                                                                          AND GL.AMDT_SEQ = A5.AMDT_SEQ" ).append("\n"); 
		query.append("                                                                          AND GL.SVC_SCP_CD = A5.SVC_SCP_CD" ).append("\n"); 
		query.append("                                                                          AND GD.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                                                                          AND GD.LOC_CD IN ('USLGB', 'USLAX', 'USOAK', 'USSFO', 'USPDX', 'USSEA', 'USTIW', 'CAPRR', 'CAVAN') " ).append("\n"); 
		query.append("                                                                        )" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("       OR (A5.ROUT_VIA_PORT_TP_CD <> 'G' AND A5.ROUT_VIA_PORT_DEF_CD IN ('USLGB', 'USLAX', 'USOAK', 'USSFO', 'USPDX', 'USSEA', 'USTIW', 'CAPRR', 'CAVAN'))" ).append("\n"); 
		query.append("       ) --D.VIA????? 9????? location????? ????????????????? ?????????????????" ).append("\n"); 
		query.append("UNION  --DEL????? 'USOMA', 'USSAT', 'USLRD', 'USLEW' CY????? ????????????????? ????????????????? block" ).append("\n"); 
		query.append("SELECT DISTINCT A3.LOC_CD ETC1 " ).append("\n"); 
		query.append("    FROM PRI_SP_SCP_RT_ROUT_PNT A1 " ).append("\n"); 
		query.append("        ,PRI_SP_SCP_GRP_LOC A2 " ).append("\n"); 
		query.append("        ,PRI_SP_SCP_GRP_LOC_DTL A3 " ).append("\n"); 
		query.append("        ,MDM_LOCATION A4 " ).append("\n"); 
		query.append("        ,MDM_EQ_ORZ_CHT A5 " ).append("\n"); 
		query.append("        ,PRI_SP_MN A6 " ).append("\n"); 
		query.append("   WHERE A1.PROP_NO = @[prop_no] " ).append("\n"); 
		query.append("     AND A1.AMDT_SEQ = @[amdt_seq] " ).append("\n"); 
		query.append("     AND A1.SVC_SCP_CD = 'TPE' --TPE Scope????? check" ).append("\n"); 
		query.append("     AND A1.ORG_DEST_TP_CD = 'D'  -- Destination????? check" ).append("\n"); 
		query.append("     AND A1.SRC_INFO_CD <> 'AD' " ).append("\n"); 
		query.append("     AND A1.ROUT_PNT_LOC_TP_CD = 'G'  --Group location ????? ????????????" ).append("\n"); 
		query.append("     AND A1.ROUT_PNT_LOC_DEF_CD = A2.PRC_GRP_LOC_CD " ).append("\n"); 
		query.append("     AND A1.PROP_NO = A2.PROP_NO " ).append("\n"); 
		query.append("     AND A1.AMDT_SEQ = A2.AMDT_SEQ " ).append("\n"); 
		query.append("     AND A1.SVC_SCP_CD = A2.SVC_SCP_CD " ).append("\n"); 
		query.append("     AND A2.PROP_NO = A3.PROP_NO " ).append("\n"); 
		query.append("     AND A2.AMDT_SEQ = A3.AMDT_SEQ " ).append("\n"); 
		query.append("     AND A2.SVC_SCP_CD = A3.SVC_SCP_CD " ).append("\n"); 
		query.append("     AND A2.GRP_LOC_SEQ  = A3.GRP_LOC_SEQ " ).append("\n"); 
		query.append("     AND A3.SRC_INFO_CD <> 'AD' " ).append("\n"); 
		query.append("     AND A3.LOC_CD = A4.LOC_CD " ).append("\n"); 
		query.append("     AND A4.SCC_CD = A5.SCC_CD " ).append("\n"); 
		query.append("     AND A3.LOC_CD IN ('USSAT', 'USLRD', 'USLEW', 'USELP')" ).append("\n"); 
		query.append("     AND A1.RCV_DE_TERM_CD = 'Y' -- CY term ?????" ).append("\n"); 
		query.append("     AND A1.PROP_NO = A6.PROP_NO " ).append("\n"); 
		query.append("     AND A1.AMDT_SEQ = A6.AMDT_SEQ " ).append("\n"); 
		query.append("     AND A6.EXP_DT >= TO_DATE('20140501', 'YYYYMMDD') -- 2014/05/01 ???????????? ????????????????????????? ????????????" ).append("\n"); 
		query.append("UNION " ).append("\n"); 
		query.append("   SELECT DISTINCT A1.ROUT_PNT_LOC_DEF_CD ETC1 " ).append("\n"); 
		query.append("    FROM PRI_SP_SCP_RT_ROUT_PNT A1 " ).append("\n"); 
		query.append("        ,MDM_LOCATION A2 " ).append("\n"); 
		query.append("        ,MDM_EQ_ORZ_CHT A3 " ).append("\n"); 
		query.append("        ,PRI_SP_MN A4 " ).append("\n"); 
		query.append("   WHERE A1.PROP_NO = @[prop_no] " ).append("\n"); 
		query.append("     AND A1.AMDT_SEQ = @[amdt_seq] " ).append("\n"); 
		query.append("     AND A1.SVC_SCP_CD = 'TPE' --TPE Scope????? check" ).append("\n"); 
		query.append("     AND A1.ORG_DEST_TP_CD = 'D' -- Destination????? check" ).append("\n"); 
		query.append("     AND A1.SRC_INFO_CD <> 'AD' " ).append("\n"); 
		query.append("     AND A1.ROUT_PNT_LOC_TP_CD = 'L' --Location ????? ???????????? " ).append("\n"); 
		query.append("     AND A1.ROUT_PNT_LOC_DEF_CD = A2.LOC_CD " ).append("\n"); 
		query.append("     AND A2.SCC_CD = A3.SCC_CD " ).append("\n"); 
		query.append("     AND A1.ROUT_PNT_LOC_DEF_CD IN ('USSAT', 'USLRD', 'USLEW', 'USELP')" ).append("\n"); 
		query.append("     AND A1.RCV_DE_TERM_CD = 'Y' -- CY term ?????" ).append("\n"); 
		query.append("     AND A1.PROP_NO = A4.PROP_NO " ).append("\n"); 
		query.append("     AND A1.AMDT_SEQ = A4.AMDT_SEQ " ).append("\n"); 
		query.append("     AND A4.EXP_DT >= TO_DATE('20140501', 'YYYYMMDD') -- 2014/05/01 ???????????? ????????????????????????? ????????????" ).append("\n"); 

	}
}