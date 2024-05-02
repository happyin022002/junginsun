/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RFARateQuotationDBDAOPriRqRtAdjustUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.13
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.08.13 이은섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun-Sup Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateQuotationDBDAOPriRqRtAdjustUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * pri_rq_rt를 일괄 조정한다.
	  * * 2011.06.29 김민아 [CHM-201111837] Split 20-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 건 : DUAL Table을 부적절하게 사용한 DBDAO의 SQL을 .Query로 이동   
	  * </pre>
	  */
	public RFARateQuotationDBDAOPriRqRtAdjustUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rate_adjust",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fic_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.integration").append("\n"); 
		query.append("FileName : RFARateQuotationDBDAOPriRqRtAdjustUSQL").append("\n"); 
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
		query.append("MERGE INTO PRI_RQ_RT A                         " ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	WITH VW_RATE_ADJUST_LIST AS (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#foreach( ${obj} in ${list_obj} )" ).append("\n"); 
		query.append("    #if( $velocityCount != 1 )" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("    #end				" ).append("\n"); 
		query.append("        SELECT  DECODE('$obj.getApplication()', NULL, 'NULL', '$obj.getApplication()') AS APPLICATION" ).append("\n"); 
		query.append("               ,DECODE('$obj.getOriLocDefCd()', NULL, 'NULL', '$obj.getOriLocDefCd()') AS ORI_LOC_DEF_CD" ).append("\n"); 
		query.append("               ,DECODE('$obj.getOriTermCd()', NULL, 'NULL', '$obj.getOriTermCd()') AS ORI_TERM_CD  " ).append("\n"); 
		query.append("               ,DECODE('$obj.getDestLocDefCd()', NULL, 'NULL', '$obj.getDestLocDefCd()') AS DEST_LOC_DEF_CD  " ).append("\n"); 
		query.append("               ,DECODE('$obj.getOriViaDefCd()', NULL, 'NULL', '$obj.getOriViaDefCd()') AS ORI_VIA_DEF_CD  " ).append("\n"); 
		query.append("               ,DECODE('$obj.getDestViaDefCd()', NULL, 'NULL', '$obj.getDestViaDefCd()') AS DEST_VIA_DEF_CD  " ).append("\n"); 
		query.append("               ,DECODE('$obj.getDestTermCd()', NULL, 'NULL', '$obj.getDestTermCd()') AS DEST_TERM_CD  " ).append("\n"); 
		query.append("               ,DECODE('$obj.getQttnNo()', NULL, 'NULL', '$obj.getQttnNo()') AS QTTN_NO  " ).append("\n"); 
		query.append("               ,DECODE('$obj.getQttnVerNo()', NULL, 'NULL', '$obj.getQttnVerNo()') AS QTTN_VER_NO  " ).append("\n"); 
		query.append("               ,DECODE('$obj.getGenSpclRtTpCd()', NULL, 'NULL', '$obj.getGenSpclRtTpCd()') AS GEN_SPCL_RT_TP_CD  " ).append("\n"); 
		query.append("               ,DECODE('$obj.getCmdtHdrSeq()', NULL, 'NULL', '$obj.getCmdtHdrSeq()') AS CMDT_HDR_SEQ  " ).append("\n"); 
		query.append("               ,DECODE('$obj.getMatchingPnt()', NULL, 'NULL', '$obj.getMatchingPnt()') AS MATCHING_PNT  " ).append("\n"); 
		query.append("               ,DECODE('$obj.getPer()', NULL, 'NULL', '$obj.getPer()') AS PER  " ).append("\n"); 
		query.append("               ,DECODE('$obj.getCargo()', NULL, 'NULL', '$obj.getCargo()') AS CARGO 			" ).append("\n"); 
		query.append("               ,DECODE('$obj.getCurrency()', NULL, 'NULL', '$obj.getCurrency()') AS CURRENCY  " ).append("\n"); 
		query.append("               ,DECODE('$obj.getAmount()', NULL, 'NULL', '$obj.getAmount()') AS AMOUNT  " ).append("\n"); 
		query.append("               ,DECODE('$obj.getPercent()', NULL, 'NULL', '$obj.getPercent()') AS PCNT  " ).append("\n"); 
		query.append("               ,DECODE('$obj.getUpdUsrId()', NULL, 'NULL', '$obj.getUpdUsrId()') AS UPD_USR_ID " ).append("\n"); 
		query.append("               ,(SELECT  USD_LOCL_XCH_RT " ).append("\n"); 
		query.append("                   FROM  GL_MON_XCH_RT  " ).append("\n"); 
		query.append("                  WHERE  ACCT_XCH_RT_YRMON = (SELECT  MAX(ACCT_XCH_RT_YRMON) " ).append("\n"); 
		query.append("                                                FROM  GL_MON_XCH_RT " ).append("\n"); 
		query.append("                                               WHERE  CURR_CD = '$obj.getCurrency()'" ).append("\n"); 
		query.append("                                                 AND  ACCT_XCH_RT_LVL = '1') " ).append("\n"); 
		query.append("                    AND  CURR_CD = '$obj.getCurrency()' " ).append("\n"); 
		query.append("                    AND  ACCT_XCH_RT_LVL = '1' ) XCH_RATE " ).append("\n"); 
		query.append("          FROM DUAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	) ," ).append("\n"); 
		query.append("	VW_ORI_RQ_RT_ROUT_PNT AS (" ).append("\n"); 
		query.append("		SELECT" ).append("\n"); 
		query.append("			QTTN_NO" ).append("\n"); 
		query.append("			, QTTN_VER_NO" ).append("\n"); 
		query.append("			, CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			, ROUT_SEQ" ).append("\n"); 
		query.append("			, ORG_DEST_TP_CD" ).append("\n"); 
		query.append("			, ROUT_PNT_SEQ" ).append("\n"); 
		query.append("			, ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("			, ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("			, PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("			, RCV_DE_TERM_CD" ).append("\n"); 
		query.append("			, SRC_INFO_CD" ).append("\n"); 
		query.append("		FROM PRI_RQ_RT_ROUT_PNT" ).append("\n"); 
		query.append("		WHERE QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("		AND QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("		AND ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("	)," ).append("\n"); 
		query.append("	VW_DEST_RQ_RT_ROUT_PNT AS (" ).append("\n"); 
		query.append("		SELECT" ).append("\n"); 
		query.append("			QTTN_NO" ).append("\n"); 
		query.append("			, QTTN_VER_NO" ).append("\n"); 
		query.append("			, CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			, ROUT_SEQ" ).append("\n"); 
		query.append("			, ORG_DEST_TP_CD" ).append("\n"); 
		query.append("			, ROUT_PNT_SEQ" ).append("\n"); 
		query.append("			, ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("			, ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("			, PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("			, RCV_DE_TERM_CD" ).append("\n"); 
		query.append("			, SRC_INFO_CD" ).append("\n"); 
		query.append("		FROM PRI_RQ_RT_ROUT_PNT" ).append("\n"); 
		query.append("		WHERE QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("		AND QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("		AND ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("	)," ).append("\n"); 
		query.append("	VW_ORI_RQ_RT_ROUT_VIA AS (" ).append("\n"); 
		query.append("		SELECT" ).append("\n"); 
		query.append("			QTTN_NO" ).append("\n"); 
		query.append("			, QTTN_VER_NO" ).append("\n"); 
		query.append("			, CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			, ROUT_SEQ" ).append("\n"); 
		query.append("			, ORG_DEST_TP_CD" ).append("\n"); 
		query.append("			, ROUT_VIA_SEQ" ).append("\n"); 
		query.append("			, ROUT_VIA_PORT_TP_CD" ).append("\n"); 
		query.append("			, ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("			, SRC_INFO_CD" ).append("\n"); 
		query.append("		FROM PRI_RQ_RT_ROUT_VIA" ).append("\n"); 
		query.append("		WHERE QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("		AND QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("		AND ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("	)," ).append("\n"); 
		query.append("	VW_DEST_RQ_RT_ROUT_VIA AS (" ).append("\n"); 
		query.append("		SELECT" ).append("\n"); 
		query.append("			QTTN_NO" ).append("\n"); 
		query.append("			, QTTN_VER_NO" ).append("\n"); 
		query.append("			, CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			, ROUT_SEQ" ).append("\n"); 
		query.append("			, ORG_DEST_TP_CD" ).append("\n"); 
		query.append("			, ROUT_VIA_SEQ" ).append("\n"); 
		query.append("			, ROUT_VIA_PORT_TP_CD" ).append("\n"); 
		query.append("			, ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("			, SRC_INFO_CD" ).append("\n"); 
		query.append("		FROM PRI_RQ_RT_ROUT_VIA" ).append("\n"); 
		query.append("		WHERE QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("		AND QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("		AND ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("	)," ).append("\n"); 
		query.append("	VW_EXCLUDE_RT AS (" ).append("\n"); 
		query.append("		SELECT DISTINCT" ).append("\n"); 
		query.append("			RT.QTTN_NO" ).append("\n"); 
		query.append("			, RT.QTTN_VER_NO" ).append("\n"); 
		query.append("			, RT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			, RT.ROUT_SEQ" ).append("\n"); 
		query.append("			, RT.RT_SEQ" ).append("\n"); 
		query.append("		FROM	VW_RATE_ADJUST_LIST VW_RATE" ).append("\n"); 
		query.append("			, PRI_RQ_RT_CMDT_ROUT MN" ).append("\n"); 
		query.append("			, VW_ORI_RQ_RT_ROUT_PNT VM_ORI_PNT" ).append("\n"); 
		query.append("			, VW_DEST_RQ_RT_ROUT_PNT VM_DEST_PNT" ).append("\n"); 
		query.append("			, VW_ORI_RQ_RT_ROUT_VIA VM_ORI_VIA" ).append("\n"); 
		query.append("			, VW_DEST_RQ_RT_ROUT_VIA VM_DEST_VIA" ).append("\n"); 
		query.append("			, PRI_RQ_RT RT" ).append("\n"); 
		query.append("		WHERE	" ).append("\n"); 
		query.append("			  MN.QTTN_NO = RT.QTTN_NO" ).append("\n"); 
		query.append("			AND MN.QTTN_VER_NO = RT.QTTN_VER_NO" ).append("\n"); 
		query.append("			AND MN.CMDT_HDR_SEQ = RT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			AND MN.ROUT_SEQ = RT.ROUT_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			AND MN.QTTN_NO = VW_RATE.QTTN_NO" ).append("\n"); 
		query.append("			AND MN.QTTN_VER_NO = VW_RATE.QTTN_VER_NO" ).append("\n"); 
		query.append("			AND MN.CMDT_HDR_SEQ = VW_RATE.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			AND MN.QTTN_NO = VM_ORI_PNT.QTTN_NO(+)" ).append("\n"); 
		query.append("			AND MN.QTTN_VER_NO = VM_ORI_PNT.QTTN_VER_NO(+)" ).append("\n"); 
		query.append("			AND MN.CMDT_HDR_SEQ = VM_ORI_PNT.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("			AND MN.ROUT_SEQ = VM_ORI_PNT.ROUT_SEQ(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			AND MN.QTTN_NO = VM_DEST_PNT.QTTN_NO(+)" ).append("\n"); 
		query.append("			AND MN.QTTN_VER_NO = VM_DEST_PNT.QTTN_VER_NO(+)" ).append("\n"); 
		query.append("			AND MN.CMDT_HDR_SEQ = VM_DEST_PNT.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("			AND MN.ROUT_SEQ = VM_DEST_PNT.ROUT_SEQ(+)" ).append("\n"); 
		query.append("			AND MN.QTTN_NO = VM_ORI_VIA.QTTN_NO(+)" ).append("\n"); 
		query.append("			AND MN.QTTN_VER_NO = VM_ORI_VIA.QTTN_VER_NO(+)" ).append("\n"); 
		query.append("			AND MN.CMDT_HDR_SEQ = VM_ORI_VIA.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("			AND MN.ROUT_SEQ = VM_ORI_VIA.ROUT_SEQ(+)" ).append("\n"); 
		query.append("			AND MN.QTTN_NO = VM_DEST_VIA.QTTN_NO(+)" ).append("\n"); 
		query.append("			AND MN.QTTN_VER_NO = VM_DEST_VIA.QTTN_VER_NO(+)" ).append("\n"); 
		query.append("			AND MN.CMDT_HDR_SEQ = VM_DEST_VIA.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("			AND MN.ROUT_SEQ = VM_DEST_VIA.ROUT_SEQ(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			AND VW_RATE.APPLICATION = 'E'" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("			AND VW_RATE.CARGO = DECODE(VW_RATE.CARGO,'NULL',VW_RATE.CARGO,RT.PRC_CGO_TP_CD)" ).append("\n"); 
		query.append("			AND VW_RATE.PER = DECODE(VW_RATE.PER,'NULL',VW_RATE.PER,RT.RAT_UT_CD )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			AND VW_RATE.ORI_LOC_DEF_CD = DECODE(VW_RATE.ORI_LOC_DEF_CD,'NULL',VW_RATE.ORI_LOC_DEF_CD,VM_ORI_PNT.ROUT_PNT_LOC_DEF_CD)" ).append("\n"); 
		query.append("			AND VW_RATE.ORI_TERM_CD = DECODE(VW_RATE.ORI_TERM_CD,'NULL',VW_RATE.ORI_TERM_CD,VM_ORI_PNT.RCV_DE_TERM_CD)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			AND VW_RATE.DEST_LOC_DEF_CD = DECODE(VW_RATE.DEST_LOC_DEF_CD,'NULL',VW_RATE.DEST_LOC_DEF_CD,VM_DEST_PNT.ROUT_PNT_LOC_DEF_CD)" ).append("\n"); 
		query.append("			AND VW_RATE.DEST_TERM_CD = DECODE(VW_RATE.DEST_TERM_CD,'NULL',VW_RATE.DEST_TERM_CD,VM_DEST_PNT.RCV_DE_TERM_CD)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			AND VW_RATE.ORI_VIA_DEF_CD = DECODE(VW_RATE.ORI_VIA_DEF_CD,'NULL',VW_RATE.ORI_VIA_DEF_CD,VM_ORI_VIA.ROUT_VIA_PORT_DEF_CD)" ).append("\n"); 
		query.append("			AND VW_RATE.DEST_VIA_DEF_CD = DECODE(VW_RATE.DEST_VIA_DEF_CD,'NULL',VW_RATE.DEST_VIA_DEF_CD,VM_DEST_VIA.ROUT_VIA_PORT_DEF_CD)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT QTTN_NO" ).append("\n"); 
		query.append("		, QTTN_VER_NO" ).append("\n"); 
		query.append("		, CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		, ROUT_SEQ" ).append("\n"); 
		query.append("		, RT_SEQ" ).append("\n"); 
		query.append("		, RAT_UT_CD" ).append("\n"); 
		query.append("		, PRC_CGO_TP_CD" ).append("\n"); 
		query.append("		, CURR_CD" ).append("\n"); 
		query.append("		, PRS_SCG_AMT" ).append("\n"); 
		query.append("		, QTTN_RT_AMT" ).append("\n"); 
		query.append("		, VAL" ).append("\n"); 
		query.append("		, PCNT" ).append("\n"); 
		query.append("		, MATCHING_PNT" ).append("\n"); 
		query.append("		, RK" ).append("\n"); 
		query.append("	FROM (" ).append("\n"); 
		query.append("		SELECT " ).append("\n"); 
		query.append("			RT.QTTN_NO" ).append("\n"); 
		query.append("			, RT.QTTN_VER_NO" ).append("\n"); 
		query.append("			, RT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			, RT.ROUT_SEQ" ).append("\n"); 
		query.append("			, RT.RT_SEQ" ).append("\n"); 
		query.append("			, RT.RAT_UT_CD" ).append("\n"); 
		query.append("			, RT.PRC_CGO_TP_CD" ).append("\n"); 
		query.append("			, RT.CURR_CD" ).append("\n"); 
		query.append("			, RT.PRS_SCG_AMT" ).append("\n"); 
		query.append("			, RT.QTTN_RT_AMT" ).append("\n"); 
		query.append("			, DECODE( @[rate_adjust],'AMT',RT.QTTN_RT_AMT + (VW_RATE.AMOUNT/VW_RATE.XCH_RATE), RT.QTTN_RT_AMT + (RT.QTTN_RT_AMT * (VW_RATE.PCNT/100)) ) VAL" ).append("\n"); 
		query.append("			, VW_RATE.PCNT" ).append("\n"); 
		query.append("			, VW_RATE.MATCHING_PNT" ).append("\n"); 
		query.append("			, RANK() OVER(PARTITION BY RT.CMDT_HDR_SEQ,RT.ROUT_SEQ,RT.RT_SEQ ORDER BY VW_RATE.MATCHING_PNT DESC , VW_RATE.AMOUNT DESC,ROWNUM) RK" ).append("\n"); 
		query.append("		FROM	VW_RATE_ADJUST_LIST VW_RATE" ).append("\n"); 
		query.append("			, PRI_RQ_RT_CMDT_ROUT MN" ).append("\n"); 
		query.append("			, VW_ORI_RQ_RT_ROUT_PNT VM_ORI_PNT" ).append("\n"); 
		query.append("			, VW_DEST_RQ_RT_ROUT_PNT VM_DEST_PNT" ).append("\n"); 
		query.append("			, VW_ORI_RQ_RT_ROUT_VIA VM_ORI_VIA" ).append("\n"); 
		query.append("			, VW_DEST_RQ_RT_ROUT_VIA VM_DEST_VIA" ).append("\n"); 
		query.append("			, PRI_RQ_RT RT" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("		WHERE	" ).append("\n"); 
		query.append("			 MN.QTTN_NO = RT.QTTN_NO" ).append("\n"); 
		query.append("			AND MN.QTTN_VER_NO = RT.QTTN_VER_NO" ).append("\n"); 
		query.append("			AND MN.CMDT_HDR_SEQ = RT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			AND MN.ROUT_SEQ = RT.ROUT_SEQ" ).append("\n"); 
		query.append("			and MN.QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("			AND MN.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			AND MN.QTTN_NO = VM_ORI_PNT.QTTN_NO(+)" ).append("\n"); 
		query.append("			AND MN.QTTN_VER_NO = VM_ORI_PNT.QTTN_VER_NO(+)" ).append("\n"); 
		query.append("			AND MN.CMDT_HDR_SEQ = VM_ORI_PNT.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("			AND MN.ROUT_SEQ = VM_ORI_PNT.ROUT_SEQ(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			AND MN.QTTN_NO = VM_DEST_PNT.QTTN_NO(+)" ).append("\n"); 
		query.append("			AND MN.QTTN_VER_NO = VM_DEST_PNT.QTTN_VER_NO(+)" ).append("\n"); 
		query.append("			AND MN.CMDT_HDR_SEQ = VM_DEST_PNT.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("			AND MN.ROUT_SEQ = VM_DEST_PNT.ROUT_SEQ(+)" ).append("\n"); 
		query.append("			AND MN.QTTN_NO = VM_ORI_VIA.QTTN_NO(+)" ).append("\n"); 
		query.append("			AND MN.QTTN_VER_NO = VM_ORI_VIA.QTTN_VER_NO(+)" ).append("\n"); 
		query.append("			AND MN.CMDT_HDR_SEQ = VM_ORI_VIA.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("			AND MN.ROUT_SEQ = VM_ORI_VIA.ROUT_SEQ(+)" ).append("\n"); 
		query.append("			AND MN.QTTN_NO = VM_DEST_VIA.QTTN_NO(+)" ).append("\n"); 
		query.append("			AND MN.QTTN_VER_NO = VM_DEST_VIA.QTTN_VER_NO(+)" ).append("\n"); 
		query.append("			AND MN.CMDT_HDR_SEQ = VM_DEST_VIA.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("			AND MN.ROUT_SEQ = VM_DEST_VIA.ROUT_SEQ(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			AND MN.QTTN_NO = VW_RATE.QTTN_NO" ).append("\n"); 
		query.append("			AND MN.QTTN_VER_NO = VW_RATE.QTTN_VER_NO" ).append("\n"); 
		query.append("			AND MN.CMDT_HDR_SEQ = VW_RATE.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			AND VW_RATE.APPLICATION = 'I'" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("			AND VW_RATE.CARGO = DECODE(VW_RATE.CARGO,'NULL',VW_RATE.CARGO,RT.PRC_CGO_TP_CD)" ).append("\n"); 
		query.append("			AND VW_RATE.PER = DECODE(VW_RATE.PER,'NULL',VW_RATE.PER,RT.RAT_UT_CD )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			AND VW_RATE.ORI_LOC_DEF_CD = DECODE(VW_RATE.ORI_LOC_DEF_CD,'NULL',VW_RATE.ORI_LOC_DEF_CD,VM_ORI_PNT.ROUT_PNT_LOC_DEF_CD)" ).append("\n"); 
		query.append("			AND VW_RATE.ORI_TERM_CD = DECODE(VW_RATE.ORI_TERM_CD,'NULL',VW_RATE.ORI_TERM_CD,VM_ORI_PNT.RCV_DE_TERM_CD)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			AND VW_RATE.DEST_LOC_DEF_CD = DECODE(VW_RATE.DEST_LOC_DEF_CD,'NULL',VW_RATE.DEST_LOC_DEF_CD,VM_DEST_PNT.ROUT_PNT_LOC_DEF_CD)" ).append("\n"); 
		query.append("			AND VW_RATE.DEST_TERM_CD = DECODE(VW_RATE.DEST_TERM_CD,'NULL',VW_RATE.DEST_TERM_CD,VM_DEST_PNT.RCV_DE_TERM_CD)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			AND VW_RATE.ORI_VIA_DEF_CD = DECODE(VW_RATE.ORI_VIA_DEF_CD,'NULL',VW_RATE.ORI_VIA_DEF_CD,VM_ORI_VIA.ROUT_VIA_PORT_DEF_CD)" ).append("\n"); 
		query.append("			AND VW_RATE.DEST_VIA_DEF_CD = DECODE(VW_RATE.DEST_VIA_DEF_CD,'NULL',VW_RATE.DEST_VIA_DEF_CD,VM_DEST_VIA.ROUT_VIA_PORT_DEF_CD)" ).append("\n"); 
		query.append("			AND EXISTS (SELECT 'T'" ).append("\n"); 
		query.append("							    FROM PRI_RQ_RT_CMDT_HDR G" ).append("\n"); 
		query.append("							   WHERE G.QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("								 AND G.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("								 AND NVL(G.FIC_RT_TP_CD, 'G') = NVL(@[fic_rt_tp_cd], 'G'))" ).append("\n"); 
		query.append("			AND NOT EXISTS (	SELECT 'F' " ).append("\n"); 
		query.append("						FROM VW_EXCLUDE_RT EX" ).append("\n"); 
		query.append("						WHERE	 EX.QTTN_NO = RT.QTTN_NO" ).append("\n"); 
		query.append("							AND EX.QTTN_VER_NO = RT.QTTN_VER_NO" ).append("\n"); 
		query.append("							AND EX.CMDT_HDR_SEQ = RT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("							AND EX.ROUT_SEQ = RT.ROUT_SEQ" ).append("\n"); 
		query.append("							AND EX.RT_SEQ = RT.RT_SEQ" ).append("\n"); 
		query.append("					)            " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("	WHERE RK = 1" ).append("\n"); 
		query.append(" ) B                                 " ).append("\n"); 
		query.append("   ON (  " ).append("\n"); 
		query.append("   A.QTTN_NO = B.QTTN_NO" ).append("\n"); 
		query.append("AND A.QTTN_VER_NO = B.QTTN_VER_NO" ).append("\n"); 
		query.append("AND A.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND A.ROUT_SEQ = B.ROUT_SEQ" ).append("\n"); 
		query.append("AND A.RT_SEQ = B.RT_SEQ" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append(" WHEN MATCHED THEN                                       " ).append("\n"); 
		query.append("     UPDATE SET        " ).append("\n"); 
		query.append("				A.QTTN_RT_AMT = B.VAL" ).append("\n"); 
		query.append("				,A.QTTN_RT_ADJ_TP_CD = 'A'" ).append("\n"); 
		query.append("                ,A.UPD_DT      = SYSDATE" ).append("\n"); 

	}
}