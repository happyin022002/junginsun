/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : UsaInbondTransmissionDBDAOsearchInbondManifestMIBSummaryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.04.11
*@LastModifier : 
*@LastVersion : 1.0
* 2017.04.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaInbondTransmissionDBDAOsearchInbondManifestMIBSummaryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim 0408 요약조회
	  * </pre>
	  */
	public UsaInbondTransmissionDBDAOsearchInbondManifestMIBSummaryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ibd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaInbondTransmissionDBDAOsearchInbondManifestMIBSummaryRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("         SUB1.HUB_LOC_CD " ).append("\n"); 
		query.append("        ,SUB1.DEL_CD" ).append("\n"); 
		query.append("		,SUB1.CSTMS_LOC_CD" ).append("\n"); 
		query.append("        ,SUB1.IBD_TRSP_NO" ).append("\n"); 
		query.append("        ,SUB1.IBD_TP_CD " ).append("\n"); 
		query.append("        ,NVL(SUB1.TOTAL_BL_CNT, 0) TOTAL_BL_CNT " ).append("\n"); 
		query.append("        ,NVL(SUB1.INBOND_BL_CNT, 0) INBOND_BL_CNT" ).append("\n"); 
		query.append("        ,NVL(SUB1.LOCAL_BL_CNT, 0) LOCAL_BL_CNT" ).append("\n"); 
		query.append("        ,SUB1.POD_CD" ).append("\n"); 
		query.append("        ,SUB1.VVD" ).append("\n"); 
		query.append("        ,SUB1.POD_SCC " ).append("\n"); 
		query.append("        ,SUB1.DEL_SCC" ).append("\n"); 
		query.append("  FROM  " ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("            I.HUB_LOC_CD, I.DEL_CD, I.CSTMS_LOC_CD," ).append("\n"); 
		query.append("            MAX(DECODE(SUBSTR(IBD.IBD_TRSP_NO,1,3),'V5N',IBD.IBD_TRSP_NO,'')) IBD_TRSP_NO," ).append("\n"); 
		query.append("            MAX(IBD.IBD_TRSP_TP_CD) IBD_TP_CD ," ).append("\n"); 
		query.append("            COUNT(I.BL_NO) TOTAL_BL_CNT," ).append("\n"); 
		query.append("            SUM(DECODE(IBD.CSTMS_CLR_TP_CD, 'I', 1)) INBOND_BL_CNT," ).append("\n"); 
		query.append("            SUM(DECODE(IBD.CSTMS_CLR_TP_CD, 'L', 1)) LOCAL_BL_CNT," ).append("\n"); 
		query.append("            MAX(I.CSTMS_POD_CD) POD_CD," ).append("\n"); 
		query.append("            MAX(I.VSL_CD || I.SKD_VOY_NO || I.SKD_DIR_CD) VVD" ).append("\n"); 
		query.append("            ,(" ).append("\n"); 
		query.append("                SELECT SCC_CD FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE LOC_CD = @[pod]" ).append("\n"); 
		query.append("            ) POD_SCC" ).append("\n"); 
		query.append("            ,(" ).append("\n"); 
		query.append("                SELECT SCC_CD FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE LOC_CD = I.DEL_CD" ).append("\n"); 
		query.append("            ) DEL_SCC" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("        FROM BKG_CSTMS_ADV_BL I, BKG_CSTMS_ADV_IBD IBD, BKG_CGO_RLSE CR" ).append("\n"); 
		query.append("        WHERE I.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("        AND I.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("        AND I.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("        AND I.CSTMS_POD_CD = @[pod]" ).append("\n"); 
		query.append("        #if (${ibd_tp_cd} != '')" ).append("\n"); 
		query.append("        	AND IBD_TRSP_TP_CD = @[ibd_tp_cd]" ).append("\n"); 
		query.append("        #end        " ).append("\n"); 
		query.append("        AND I.CNT_CD = IBD.CNT_CD" ).append("\n"); 
		query.append("        AND I.CNT_CD = 'US'" ).append("\n"); 
		query.append("        AND I.BL_NO = IBD.BL_NO" ).append("\n"); 
		query.append("        AND I.MF_STS_CD = 'A'" ).append("\n"); 
		query.append("        AND I.BL_NO = CR.BL_NO(+)" ).append("\n"); 
		query.append("        AND (CR.CSTMS_CLR_CD is null OR CR.CSTMS_CLR_CD <> 'Y')" ).append("\n"); 
		query.append("		AND IBD.CSTMS_CLR_TP_CD IN ('I', 'L')" ).append("\n"); 
		query.append("		AND I.MF_NO IS NULL" ).append("\n"); 
		query.append("		GROUP BY I.HUB_LOC_CD, I.DEL_CD, I.CSTMS_LOC_CD" ).append("\n"); 
		query.append("       ) SUB1" ).append("\n"); 
		query.append("        -- 2009/11/13" ).append("\n"); 
		query.append("        -- 정민정과장, 하동일 수석, 경종윤" ).append("\n"); 
		query.append("        -- 내용 : 로컬만 조회 요청" ).append("\n"); 
		query.append("   	    -- 2010/05/20(로직추가) " ).append("\n"); 
		query.append("		-- 정민정과장, 하동일수석, 이동욱과장, 경종윤" ).append("\n"); 
		query.append("        -- 내용 : POD SCC = DEL SCC 이더라도,  POD <> HUB 이면 조회되도록 함 " ).append("\n"); 
		query.append(" WHERE DECODE(SUB1.IBD_TP_CD,'62',0,'63',0, DECODE(SUB1.POD_SCC, SUB1.DEL_SCC, DECODE(SUB1.POD_CD, SUB1.HUB_LOC_CD, 1, 0), 0)) = 0" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pod} == 'USLGB' || ${pod} == 'USLAX' || ${pod} == 'USSEA'  || ${pod} == 'USTIW' || ${pod} == 'USOAK') " ).append("\n"); 
		query.append("	AND (" ).append("\n"); 
		query.append("	-- 아래의 경우는 조회되지 않아야 함. 2009/11/23" ).append("\n"); 
		query.append("	-- 메일 내용중, 다른건 정상적으로 조회가 되는데 OD: USLGB로 조회시 USLAX 가 대상으로 보이고 있습니다" ).append("\n"); 
		query.append("	-- USLAX 의 SCC가 USLAX이므로 로직상 나오는건 맞는것 같은데 업무적으로는 나오면 안되는 DEL 입니다" ).append("\n"); 
		query.append("	-- 에 대한 처리, 이와 동일한 조건의 POD, HUB 추가." ).append("\n"); 
		query.append("    -- 2010/06/16 하동일수석, 경종윤 (IBD_TP_CD가 62, 63이 아닐 경우로 수정)" ).append("\n"); 
		query.append("	DECODE(SUB1.IBD_TP_CD,'62','N','63','N',DECODE(@[pod], 'USLGB', DECODE(HUB_LOC_CD, 'USLAX', 'Y', 'USGAC', 'Y', 'N'),'Y')) = 'N'" ).append("\n"); 
		query.append("	OR DECODE(SUB1.IBD_TP_CD,'62','N','63','N',DECODE(@[pod], 'USLAX', DECODE(HUB_LOC_CD, 'USLGB', 'Y', 'N'),'Y')) = 'N'" ).append("\n"); 
		query.append("	OR DECODE(SUB1.IBD_TP_CD,'62','N','63','N',DECODE(@[pod], 'USSEA', DECODE(HUB_LOC_CD, 'USTIW', 'Y', 'N'),'Y')) = 'N'" ).append("\n"); 
		query.append("	OR DECODE(SUB1.IBD_TP_CD,'62','N','63','N',DECODE(@[pod], 'USTIW', DECODE(HUB_LOC_CD, 'USSEA', 'Y', 'N'),'Y')) = 'N'" ).append("\n"); 
		query.append("	OR DECODE(SUB1.IBD_TP_CD,'62','N','63','N',DECODE(@[pod], 'USOAK', DECODE(HUB_LOC_CD, 'USSFO', 'Y', 'N'),'Y')) = 'N'" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY SUB1.HUB_LOC_CD, SUB1.DEL_CD, SUB1.CSTMS_LOC_CD" ).append("\n"); 

	}
}