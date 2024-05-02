/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChangeOfDestinationMgtDBDAOCODRequestListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChangeOfDestinationMgtDBDAOCODRequestListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * History-------------------------------------
	  * 2010.07.26 LHJ [Ticket-ID:CHM-201004935] COD application 조회 기능 추가 요청 및 에러 수정건
	  * </pre>
	  */
	public ChangeOfDestinationMgtDBDAOCODRequestListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rso",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_rqst_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration").append("\n"); 
		query.append("FileName : ChangeOfDestinationMgtDBDAOCODRequestListVORSQL").append("\n"); 
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
		query.append("SELECT A.VSL_SLAN_CD,A.VSL_OPR_CD," ).append("\n"); 
		query.append("       A.VVD," ).append("\n"); 
		query.append("       A.BKG_NO," ).append("\n"); 
		query.append("       A.COD_RQST_RSN_CD," ).append("\n"); 
		query.append("       A.OLD_POL," ).append("\n"); 
		query.append("       A.OLD_POD," ).append("\n"); 
		query.append("       A.OLD_DEL," ).append("\n"); 
		query.append("       A.NEW_POL," ).append("\n"); 
		query.append("       A.NEW_POD," ).append("\n"); 
		query.append("       A.NEW_DEL," ).append("\n"); 
		query.append("       --COUNT(C.CNTR_NO) CNTR_QTY," ).append("\n"); 
		query.append("       A.RAT_AS_QTY CNTR_QTY," ).append("\n"); 
		query.append("       A.COD_RQST_OFC_CD,	" ).append("\n"); 
		query.append("       A.COD_STS_CD," ).append("\n"); 
		query.append("       A.CHG_AMT," ).append("\n"); 
		query.append("       --A.DIFF_RMK," ).append("\n"); 
		query.append("       REPLACE(A.DIFF_RMK,CHR(10),'\r\n') DIFF_RMK," ).append("\n"); 
		query.append("       A.BL_NO," ).append("\n"); 
		query.append("       A.COD_RQST_SEQ," ).append("\n"); 
		query.append("       A.COD_RHND_PORT_CD," ).append("\n"); 
		query.append("       A.ACT_DEPT_YN," ).append("\n"); 
		query.append("       A.POD_ETA_DT," ).append("\n"); 
		query.append("       ----::2015-06-10::----A.COD_EMAIL_SEND_YN" ).append("\n"); 
		query.append("	   'Y'	AS COD_EMAIL_SEND_YN," ).append("\n"); 
		query.append("       A.COD_RHND_PORT_YD_CD," ).append("\n"); 
		query.append("       A.COST_CD_RQST_SEQ" ).append("\n"); 
		query.append("FROM   (SELECT I.VSL_SLAN_CD,I.VSL_OPR_CD," ).append("\n"); 
		query.append("               I.VVD," ).append("\n"); 
		query.append("               I.BKG_NO," ).append("\n"); 
		query.append("               I.COD_RQST_RSN_CD," ).append("\n"); 
		query.append("               I.OLD_POL," ).append("\n"); 
		query.append("               I.OLD_POD," ).append("\n"); 
		query.append("               I.OLD_DEL," ).append("\n"); 
		query.append("               I.NEW_POL," ).append("\n"); 
		query.append("               I.NEW_POD," ).append("\n"); 
		query.append("               I.NEW_DEL," ).append("\n"); 
		query.append("               I.COD_RQST_OFC_CD," ).append("\n"); 
		query.append("               I.COD_STS_CD," ).append("\n"); 
		query.append("               --( SELECT SUM(CHG_AMT)" ).append("\n"); 
		query.append("               --  FROM   BKG_COD_COST C" ).append("\n"); 
		query.append("               --  WHERE  I.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("               --  AND    I.COD_RQST_SEQ = C.COD_RQST_SEQ ) CHG_AMT," ).append("\n"); 
		query.append("               I.CHG_AMT," ).append("\n"); 
		query.append("               I.DIFF_RMK," ).append("\n"); 
		query.append("               I.BL_NO," ).append("\n"); 
		query.append("               I.COD_RQST_SEQ," ).append("\n"); 
		query.append("               I.COD_RHND_PORT_CD," ).append("\n"); 
		query.append("               I.ACT_DEPT_YN," ).append("\n"); 
		query.append("			   I.POD_ETA_DT," ).append("\n"); 
		query.append("               I.COD_EMAIL_SEND_YN," ).append("\n"); 
		query.append("               I.COD_RHND_PORT_YD_CD," ).append("\n"); 
		query.append("               I.COST_CD_RQST_SEQ," ).append("\n"); 
		query.append("               I.RAT_AS_QTY" ).append("\n"); 
		query.append("        FROM   (" ).append("\n"); 
		query.append("                 SELECT VS.VSL_SLAN_CD,NVL(VS.ACT_CRR_CD,VC.CRR_CD) AS VSL_OPR_CD," ).append("\n"); 
		query.append("                        BC.OLD_VSL_CD||BC.OLD_SKD_VOY_NO||BC.OLD_SKD_DIR_CD VVD," ).append("\n"); 
		query.append("                        BC.BKG_NO," ).append("\n"); 
		query.append("                        BC.COD_RQST_RSN_CD," ).append("\n"); 
		query.append("                        SUBSTR(BC.OLD_POL_YD_CD, 1, 5) OLD_POL," ).append("\n"); 
		query.append("                        SUBSTR(BC.OLD_POD_YD_CD, 1, 5) OLD_POD," ).append("\n"); 
		query.append("                        SUBSTR(BC.OLD_DEL_YD_CD, 1, 5) OLD_DEL," ).append("\n"); 
		query.append("                        SUBSTR(BC.NEW_POL_YD_CD, 1, 5) NEW_POL," ).append("\n"); 
		query.append("                        SUBSTR(BC.NEW_POD_YD_CD, 1, 5) NEW_POD," ).append("\n"); 
		query.append("                        SUBSTR(BC.NEW_DEL_YD_CD, 1, 5) NEW_DEL," ).append("\n"); 
		query.append("                        BC.COD_RQST_OFC_CD," ).append("\n"); 
		query.append("                        BC.COD_STS_CD," ).append("\n"); 
		query.append("                        BC.DIFF_RMK," ).append("\n"); 
		query.append("                        BB.BL_NO," ).append("\n"); 
		query.append("                        MAX(BC.COD_RQST_SEQ) COD_RQST_SEQ," ).append("\n"); 
		query.append("                        --BC.COD_RHND_PORT_CD," ).append("\n"); 
		query.append("                        DECODE(BCC.COD_RHND_PORT_YD_CD,NULL,'',SUBSTR(BCC.COD_RHND_PORT_YD_CD,0,5)) COD_RHND_PORT_CD," ).append("\n"); 
		query.append("                        DECODE(BC.COD_STS_CD, 'R', DECODE(VAPS.ACT_DEP_DT, NULL, 'Y', 'N'), 'Y') ACT_DEPT_YN," ).append("\n"); 
		query.append("						BB.POD_ETA_DT," ).append("\n"); 
		query.append("                        CASE WHEN BB.POD_ETA_DT > SYSDATE THEN 'Y' ELSE 'N'" ).append("\n"); 
		query.append("                        END COD_EMAIL_SEND_YN," ).append("\n"); 
		query.append("                        BCC.COD_RHND_PORT_YD_CD," ).append("\n"); 
		query.append("                        BCC.COST_CD_RQST_SEQ," ).append("\n"); 
		query.append("                        BCC.CHG_AMT," ).append("\n"); 
		query.append("                        BCC.RAT_AS_QTY" ).append("\n"); 
		query.append("                 FROM   BKG_COD 				BC " ).append("\n"); 
		query.append("					,	VSK_VSL_SKD 			VS " ).append("\n"); 
		query.append("					,	BKG_COD_CNTR 			BCN " ).append("\n"); 
		query.append("					,	BKG_BOOKING 			BB " ).append("\n"); 
		query.append("					,	VSK_ACT_PORT_SKD 		VAPS" ).append("\n"); 
		query.append("					,	BKG_COD_COST 			BCC" ).append("\n"); 
		query.append("					,	MDM_VSL_CNTR 			VC" ).append("\n"); 
		query.append("                 WHERE  BC.OLD_VSL_CD     		= VS.VSL_CD				(+)" ).append("\n"); 
		query.append("                 AND    BC.OLD_SKD_VOY_NO 		= VS.SKD_VOY_NO			(+)" ).append("\n"); 
		query.append("                 AND    BC.OLD_SKD_DIR_CD 		= VS.SKD_DIR_CD			(+)" ).append("\n"); 
		query.append("                 AND    BC.OLD_VSL_CD     		= VAPS.VSL_CD			(+)" ).append("\n"); 
		query.append("                 AND    BC.OLD_SKD_VOY_NO 		= VAPS.SKD_VOY_NO		(+)" ).append("\n"); 
		query.append("                 AND    BC.OLD_SKD_DIR_CD 		= VAPS.SKD_DIR_CD		(+)" ).append("\n"); 
		query.append("                 AND    SUBSTR(BC.OLD_POD_YD_CD,1,5) = VAPS.VPS_PORT_CD	(+)" ).append("\n"); 
		query.append("				 AND    VS.VSL_CD        		= VC.VSL_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND    BC.RGN_CD         = @[rso]" ).append("\n"); 
		query.append("#if (${slan_cd} != '')" ).append("\n"); 
		query.append("AND    VS.VSL_SLAN_CD    = @[slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("AND    ( BC.OLD_VSL_CD     = @[vsl_cd] )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("AND    ( BC.OLD_SKD_VOY_NO = @[skd_voy_no] )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("AND    ( BC.OLD_SKD_DIR_CD = @[skd_dir_cd] )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cod_sts_cd} != '')" ).append("\n"); 
		query.append("AND    BC.COD_STS_CD     = @[cod_sts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cod_rqst_rsn_cd} != 'All')" ).append("\n"); 
		query.append("AND    BC.COD_RQST_RSN_CD     = @[cod_rqst_rsn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_no} != '')" ).append("\n"); 
		query.append("AND    BC.BKG_NO     = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                 AND    DECODE(BC.COD_MNL_FLG, 'Y', 'Y', 'N') = 'N'" ).append("\n"); 
		query.append("                 AND    BCN.COD_SLCT_FLG = 'Y'" ).append("\n"); 
		query.append("                 AND    BC.COD_STS_CD != 'M'" ).append("\n"); 
		query.append("                 AND    BC.BKG_NO = BCN.BKG_NO" ).append("\n"); 
		query.append("                 AND    BC.COD_RQST_SEQ = BCN.COD_RQST_SEQ" ).append("\n"); 
		query.append("                 AND    BC.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("                 AND    BC.COD_STS_CD IS NOT NULL" ).append("\n"); 
		query.append("                 AND    BC.BKG_NO = BCC.BKG_NO(+)" ).append("\n"); 
		query.append("                 AND    BC.COD_RQST_SEQ = BCC.COD_RQST_SEQ(+)" ).append("\n"); 
		query.append("                 GROUP BY VS.VSL_SLAN_CD, BC.OLD_VSL_CD||BC.OLD_SKD_VOY_NO||BC.OLD_SKD_DIR_CD, BC.BKG_NO, BC.COD_RQST_RSN_CD, " ).append("\n"); 
		query.append("                          BC.OLD_POL_YD_CD, BC.OLD_POD_YD_CD, BC.OLD_DEL_YD_CD, BC.NEW_POL_YD_CD, BC.NEW_POD_YD_CD, " ).append("\n"); 
		query.append("                          BC.NEW_DEL_YD_CD, BC.COD_RQST_OFC_CD, BC.COD_STS_CD, BC.DIFF_RMK, BB.BL_NO, " ).append("\n"); 
		query.append("                          DECODE(BC.COD_STS_CD, 'R', DECODE(VAPS.ACT_DEP_DT, NULL, 'Y', 'N'), 'Y')," ).append("\n"); 
		query.append("                          BB.POD_ETA_DT,BCC.COD_RHND_PORT_YD_CD,BCC.COST_CD_RQST_SEQ,BCC.CHG_AMT,BCC.RAT_AS_QTY,NVL(VS.ACT_CRR_CD,VC.CRR_CD)  " ).append("\n"); 
		query.append("               ) I) A" ).append("\n"); 
		query.append("		,	BKG_COD_CNTR 	C" ).append("\n"); 
		query.append("WHERE  		A.BKG_NO 		= C.BKG_NO" ).append("\n"); 
		query.append("AND    		A.COD_RQST_SEQ 	= C.COD_RQST_SEQ" ).append("\n"); 
		query.append("AND    		C.COD_SLCT_FLG 	= 'Y'  -- //::2014-10-27::TOP:://" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY 	A.VSL_SLAN_CD, A.VVD, A.BKG_NO, A.COD_RQST_RSN_CD, A.OLD_POL, A.OLD_POD, A.OLD_DEL, A.NEW_POL, A.NEW_POD, A.NEW_DEL," ).append("\n"); 
		query.append("         	A.COD_RQST_OFC_CD, A.COD_STS_CD, A.CHG_AMT, A.DIFF_RMK, A.BL_NO, A.COD_RQST_SEQ, A.COD_RHND_PORT_CD, A.ACT_DEPT_YN, " ).append("\n"); 
		query.append("         	A.POD_ETA_DT, A.COD_EMAIL_SEND_YN, A.COD_RHND_PORT_YD_CD, A.COST_CD_RQST_SEQ, A.RAT_AS_QTY,A.VSL_OPR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY 	A.VSL_SLAN_CD" ).append("\n"); 
		query.append("		, 	A.VVD" ).append("\n"); 
		query.append("		, 	A.BKG_NO" ).append("\n"); 
		query.append("		, 	A.COD_RQST_SEQ DESC" ).append("\n"); 
		query.append("		,	A.COST_CD_RQST_SEQ" ).append("\n"); 
		query.append(" " ).append("\n"); 

	}
}