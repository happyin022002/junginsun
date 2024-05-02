/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UsaCustomsReportDBDAOsearchBlListByCntrNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.04
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.06.04 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Minjung Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsReportDBDAOsearchBlListByCntrNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ContainerDetailVO
	  * </pre>
	  */
	public UsaCustomsReportDBDAOsearchBlListByCntrNoRSQL(){
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsReportDBDAOsearchBlListByCntrNoRSQL").append("\n"); 
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
		query.append("SELECT   CNT.CNTR_NO" ).append("\n"); 
		query.append("        ,ABL.VSL_CD || ABL.SKD_VOY_NO || ABL.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("        ,ABL.BL_NO" ).append("\n"); 
		query.append("        ,TO_CHAR(SKD.VPS_ETA_DT,'YYYY-MM-DD HH24:MI:SS') AS VPS_ETA_DT" ).append("\n"); 
		query.append("        ,ABL.POD_CD" ).append("\n"); 
		query.append("        ,ABL.DEL_CD" ).append("\n"); 
		query.append("        ,ABL.HUB_LOC_CD" ).append("\n"); 
		query.append("        ,IBD.IBD_TRSP_NO" ).append("\n"); 
		query.append("        ,IBD.IBD_TRSP_TP_CD" ).append("\n"); 
		query.append("		,NVL(CGO.FRT_CLT_FLG, 'N') AS F_FLG" ).append("\n"); 
		query.append("		,NVL(CGO.OBL_RDEM_FLG, 'N') AS O_FLG" ).append("\n"); 
		query.append("		,NVL(CGO.CSTMS_CLR_CD, 'N') AS C_FLG" ).append("\n"); 
		query.append("		,DECODE(ABL.MF_NO, null,'Master B/L','House B/L') AS MF_NO" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ADV_BL ABL" ).append("\n"); 
		query.append("    ,BKG_CSTMS_ADV_IBD IBD" ).append("\n"); 
		query.append("    ,BKG_CSTMS_ADV_CNTR CNT" ).append("\n"); 
		query.append("    ,VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("    ,BKG_CGO_RLSE CGO" ).append("\n"); 
		query.append("	,MDM_LOCATION LOC" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND     ABL.CNT_CD = 'US'" ).append("\n"); 
		query.append("AND     CNT.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#if (${vvd} != '') " ).append("\n"); 
		query.append("AND     ABL.VSL_CD     = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND		ABL.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND		ABL.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${blType} == '1')" ).append("\n"); 
		query.append("AND     ABL.MF_NO IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${blType} == '2')" ).append("\n"); 
		query.append("AND     ABL.MF_NO IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND     ABL.MF_STS_CD = 'A'" ).append("\n"); 
		query.append("AND     CNT.CNT_CD = ABL.CNT_CD" ).append("\n"); 
		query.append("AND     CNT.BL_NO = ABL.BL_NO" ).append("\n"); 
		query.append("AND     CNT.CNT_CD = IBD.CNT_CD" ).append("\n"); 
		query.append("AND     CNT.BL_NO = IBD.BL_NO" ).append("\n"); 
		query.append("AND     ABL.VSL_CD = SKD.VSL_CD" ).append("\n"); 
		query.append("AND     ABL.SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     ABL.SKD_DIR_CD = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     ABL.CSTMS_POD_CD = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("AND     SKD.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("AND     ABL.BL_NO = CGO.BL_NO(+)" ).append("\n"); 
		query.append("AND     ABL.POD_CD = LOC.LOC_CD" ).append("\n"); 
		query.append("AND     LOC.CONTI_CD = 'M'" ).append("\n"); 
		query.append("ORDER BY SKD.VPS_ETA_DT DESC, ABL.BL_NO" ).append("\n"); 

	}
}