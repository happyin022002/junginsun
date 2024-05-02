/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CntrMtyBkgCreateDBDAOSearchCntrMtyBkgSplitContainerListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.29
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2016.09.29 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrMtyBkgCreateDBDAOSearchCntrMtyBkgSplitContainerListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VL BKG 의 컨테이너 정보를 조회
	  * - 2014.03.10 ROB BKG 은 FALSE 추가, 
	  * </pre>
	  */
	public CntrMtyBkgCreateDBDAOSearchCntrMtyBkgSplitContainerListRSQL(){
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.integration").append("\n"); 
		query.append("FileName : CntrMtyBkgCreateDBDAOSearchCntrMtyBkgSplitContainerListRSQL").append("\n"); 
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
		query.append("SELECT MC.CNTR_NO      CNTR_NO" ).append("\n"); 
		query.append("      ,MC.CNTR_TPSZ_CD CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      ,MC.BKG_NO       VL_BKG_NO" ).append("\n"); 
		query.append("      ,DECODE(CM.MVMT_STS_CD, 'VL', 'OK', 'FALSE') VRFY_STATUS  " ).append("\n"); 
		query.append("      ,CM.MVMT_STS_CD  MVMT_STS_CD " ).append("\n"); 
		query.append("      ,MC.YD_CD        POL_YD_CD   " ).append("\n"); 
		query.append("      ,MC.TO_YD_CD    POD_YD_CD" ).append("\n"); 
		query.append("       -- HIDDEN AREA	" ).append("\n"); 
		query.append("      ,TO_CHAR(MC.VPS_ETD_DT,'YYYY-MM-DD HH24:MI:SS')   VPS_ETD_DT -- HIDDEN" ).append("\n"); 
		query.append("      ,MC.CLPT_SEQ     CLPT_SEQ   -- HIDDEN  " ).append("\n"); 
		query.append("      ,MC.VSL_CD" ).append("\n"); 
		query.append("      ,MC.SKD_VOY_NO " ).append("\n"); 
		query.append("      ,MC.SKD_DIR_CD" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT  CM" ).append("\n"); 
		query.append("    ,(" ).append("\n"); 
		query.append("        SELECT BB.BKG_NO," ).append("\n"); 
		query.append("               MC.CNTR_NO," ).append("\n"); 
		query.append("               MC.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("               MC.CNMV_STS_CD," ).append("\n"); 
		query.append("               BB.POD_NOD_CD TO_YD_CD," ).append("\n"); 
		query.append("			   VV.VSL_CD," ).append("\n"); 
		query.append("               VV.SKD_VOY_NO," ).append("\n"); 
		query.append("               VV.SKD_DIR_CD," ).append("\n"); 
		query.append("               VV.VPS_PORT_CD," ).append("\n"); 
		query.append("               VV.YD_CD,  -- POL YD CD" ).append("\n"); 
		query.append("               VV.VPS_ETD_DT," ).append("\n"); 
		query.append("               VV.CLPT_SEQ" ).append("\n"); 
		query.append("               --EC.MTY_ROB_FLG  -- ROB 여부 확인" ).append("\n"); 
		query.append("        FROM MST_CONTAINER MC" ).append("\n"); 
		query.append("            ,BKG_CONTAINER BC" ).append("\n"); 
		query.append("            ,BKG_BOOKING   BB" ).append("\n"); 
		query.append("            ,VSK_VSL_PORT_SKD VV" ).append("\n"); 
		query.append("        WHERE BB.BKG_NO     = BC.BKG_NO" ).append("\n"); 
		query.append("        AND   BC.CNTR_NO    = MC.CNTR_NO   " ).append("\n"); 
		query.append("        AND   BB.VSL_CD     = VV.VSL_CD" ).append("\n"); 
		query.append("        AND   BB.SKD_VOY_NO = VV.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND   BB.SKD_DIR_CD = VV.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND   BB.POL_CD     = VV.VPS_PORT_CD" ).append("\n"); 
		query.append("        AND   BB.POL_NOD_CD = VV.YD_CD" ).append("\n"); 
		query.append("        AND   VV.CALL_YD_IND_SEQ = 1 -- VSL SKD 에서 CALL_YD_IND_SEQ = 1만 추출(2013.12.02, , YD_CD 중복인 경우를 대비)" ).append("\n"); 
		query.append("        AND   MC.ACIAC_DIV_CD <> 'I'  --Active한 것만 가져온다" ).append("\n"); 
		query.append("        AND   BB.BKG_NO IN (" ).append("\n"); 
		query.append("                            SELECT BKG_NO " ).append("\n"); 
		query.append("                            FROM BKG_BOOKING" ).append("\n"); 
		query.append("                            WHERE VSL_CD     = SUBSTR(@[vvd], 0, 4)" ).append("\n"); 
		query.append("                            AND   SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                            AND   SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("    #if(${bkg_no} != 'ALL')" ).append("\n"); 
		query.append("                            AND   BKG_NO     = @[bkg_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("                            AND   BKG_CGO_TP_CD = 'P'             -- EMPTY BKG" ).append("\n"); 
		query.append("                         --   AND   NVL(BKG_CRE_TP_CD, ' ') <> 'S'  -- SPLIT BKG 제외" ).append("\n"); 
		query.append("                            AND   BKG_STS_CD <> 'X'               -- CANCEL 제외 " ).append("\n"); 
		query.append("                           )    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ) MC" ).append("\n"); 
		query.append("WHERE CM.CNTR_NO = MC.CNTR_NO" ).append("\n"); 
		query.append("AND  (CM.CNMV_YR, CM.CNMV_SEQ, CM.CNMV_SPLIT_NO) = (" ).append("\n"); 
		query.append("                                                      SELECT /*+index_desc(a XUK1CTM_MOVEMENT) */ " ).append("\n"); 
		query.append("                                                             CNMV_YR" ).append("\n"); 
		query.append("                                                            ,CNMV_SEQ" ).append("\n"); 
		query.append("                                                            ,CNMV_SPLIT_NO" ).append("\n"); 
		query.append("                                                      FROM CTM_MOVEMENT A" ).append("\n"); 
		query.append("                                                      WHERE A.CNTR_NO = MC.CNTR_NO" ).append("\n"); 
		query.append("                                                      AND ROWNUM = 1" ).append("\n"); 
		query.append("                                                   )" ).append("\n"); 

	}
}