/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ProductCatalogCreateVerifyDBDAOSearchVerifyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.common.productcatalogcreateverify.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogCreateVerifyDBDAOSearchVerifyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchVerify
	  * </pre>
	  */
	public ProductCatalogCreateVerifyDBDAOSearchVerifyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("m_pu",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_trsp_mode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_str",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_str",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n4th_pol_dc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_n",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_pod_dc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ocn_str",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_pol_dc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_pod_dc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_t",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_n",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_pol_dc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_spcl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_n",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_pod_dc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_t",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n4th_pod_dc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dg_spcl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_pol_dc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_trsp_mode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_n",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.common.productcatalogcreateverify.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateVerifyDBDAOSearchVerifyRSQL").append("\n"); 
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
		query.append("    HUB_COUNT, OB_SO_CHK,IB_SO_CHK,OCN_SO_CHK,ORG_CHECK,DEST_CHECK,ORG_FLG_CHK, DEST_FLG_CHK,CHECK_ROUT," ).append("\n"); 
		query.append("    OB_IRG_CHK,IB_IRG_CHK, " ).append("\n"); 
		query.append("    SUBSTR(regexp_replace(STS_CHECK, '(.{9})', ', \\1'), 3) STS_CHECK," ).append("\n"); 
		query.append("    ORG_LOC_CD,DEST_LOC_CD,ROUT_SEQ,LNK_KNT, NVL(SKD_STR, 'X') SKD_STR," ).append("\n"); 
		query.append("    N1ST_LANE_CD,N2ND_LANE_CD,N3RD_LANE_CD,N4TH_LANE_CD," ).append("\n"); 
		query.append("    N2ND_POL_CD,N3RD_POL_CD,N4TH_POL_CD,N1ST_SVC_TP,N2ND_SVC_TP,N3RD_SVC_TP,N4TH_SVC_TP," ).append("\n"); 
		query.append("    N1ST_TZTM_HRS,N2ND_TZTM_HRS,N3RD_TZTM_HRS,N4TH_TZTM_HRS," ).append("\n"); 
		query.append("    CCT,POL1_,POL1_S,POD1,POLT1,PODT1,VVD1,CRR1,POL_SEQ1,POD_SEQ1," ).append("\n"); 
		query.append("    POL2,POD2,POLT2,PODT2,VVD2,CRR2,POL_SEQ2,POD_SEQ2," ).append("\n"); 
		query.append("    POL3,POD3,POLT3,PODT3,VVD3,CRR3,POL_SEQ3,POD_SEQ3," ).append("\n"); 
		query.append("    POL4,POD4_,POLT4,PODT4,VVD4,CRR4,POL_SEQ4,POD_SEQ4," ).append("\n"); 
		query.append("    POD_NODE_,POD_NODE_S, OB_TRSP_MOD_CD, IB_TRSP_MOD_CD, MTPU_CY, MTRTN_CY" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("   (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("    (CASE " ).append("\n"); 
		query.append("		 WHEN O.ROUT_ORG_NOD_CD IS NULL" ).append("\n"); 
		query.append("            AND @[por] = NVL(@[pol], SUBSTR(T.POL1, 1, 5)) AND @[rcv_t] = 'S' AND POL1_S ='Y' THEN 'Y'" ).append("\n"); 
		query.append("          WHEN O.ROUT_ORG_NOD_CD IS NULL" ).append("\n"); 
		query.append("            AND @[por] = NVL(@[pol], SUBSTR(T.POL1, 1, 5)) AND @[rcv_t] <> 'D' THEN 'Y'" ).append("\n"); 
		query.append("          WHEN O.ROUT_ORG_NOD_CD IS NOT NULL" ).append("\n"); 
		query.append("            AND (SELECT 'X' FROM PRD_NODE N" ).append("\n"); 
		query.append("                 WHERE N.NOD_CD = O.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("                   AND DECODE(N.NOD_TP_CD,'Z','D',N.NOD_TP_CD) IN (DECODE(@[rcv_t],'D','D','')," ).append("\n"); 
		query.append("                                                               DECODE(@[rcv_t],'T','B','F','B','Y','B','S','B','')," ).append("\n"); 
		query.append("                                                               DECODE(@[rcv_t],'T','M','F','M','Y','M','S','M','')," ).append("\n"); 
		query.append("                                                               DECODE(@[rcv_t],'Y','Y','S','Y','')," ).append("\n"); 
		query.append("                                                               DECODE(@[rcv_t],'Y','R','S','R','')," ).append("\n"); 
		query.append("                                                               DECODE(@[rcv_t],'Y','P','') )" ).append("\n"); 
		query.append("                 ) = 'X'" ).append("\n"); 
		query.append("                 AND NVL(O.PCTL_IO_BND_CD,'O')  IN ('O','B')" ).append("\n"); 
		query.append("                 AND DECODE(@[rcv_t],'S','Y','X') = NVL((SELECT DECODE(@[rcv_t],'S',YD_FCTY_TP_CFS_FLG,'X') FROM MDM_YARD WHERE YD_CD=O.ROUT_ORG_NOD_CD),'X')" ).append("\n"); 
		query.append("                 AND O.ROUT_ORG_NOD_CD  LIKE DECODE(@[rcv_t],'F','','T',''," ).append("\n"); 
		query.append("                                                      DECODE(@[por_n],''," ).append("\n"); 
		query.append("                                                           DECODE(@[rcv_t],'D',(SELECT REP_ZN_CD FROM MDM_LOCATION WHERE LOC_CD = @[por]),@[por]||'%')" ).append("\n"); 
		query.append("                                                      ,@[por_n])" ).append("\n"); 
		query.append("                                               )" ).append("\n"); 
		query.append("                 THEN 'Y'" ).append("\n"); 
		query.append("          ELSE 'X'" ).append("\n"); 
		query.append("     END) ORG_CHECK," ).append("\n"); 
		query.append("     (CASE " ).append("\n"); 
		query.append("           WHEN I.ROUT_DEST_NOD_CD IS NULL " ).append("\n"); 
		query.append("                AND NVL(@[pod],SUBSTR( T.POD_NODE ,1,5)) = @[del] AND @[del_t] = 'S' AND POD_NODE_S ='Y' THEN 'Y' " ).append("\n"); 
		query.append("           WHEN I.ROUT_DEST_NOD_CD IS NULL " ).append("\n"); 
		query.append("                AND NVL(@[pod],SUBSTR( T.POD_NODE ,1,5)) = @[del] AND @[del_t] <> 'D' THEN 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           WHEN I.ROUT_DEST_NOD_CD IS NOT NULL" ).append("\n"); 
		query.append("				AND (SELECT 'X' FROM PRD_NODE N" ).append("\n"); 
		query.append("					 WHERE N.NOD_CD = I.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("					   AND DECODE(N.NOD_TP_CD,'Z','D',N.NOD_TP_CD) IN (DECODE(@[del_t],'D','D','')," ).append("\n"); 
		query.append("                                                               DECODE(@[del_t],'T','B','F','B','Y','B','S','B','')," ).append("\n"); 
		query.append("                                                               DECODE(@[del_t],'T','M','F','M','Y','M','S','M','')," ).append("\n"); 
		query.append("                                                               DECODE(@[del_t],'Y','Y','S','Y','')," ).append("\n"); 
		query.append("                                                               DECODE(@[del_t],'Y','R','S','R','')," ).append("\n"); 
		query.append("                                                               DECODE(@[del_t],'Y','P','') )" ).append("\n"); 
		query.append("                 ) = 'X'" ).append("\n"); 
		query.append("				 AND NVL(I.PCTL_IO_BND_CD,'I') IN ('I','B')" ).append("\n"); 
		query.append("                 AND DECODE(@[del_t],'S','Y','X') =" ).append("\n"); 
		query.append("                                        NVL((SELECT DECODE(@[del_t],'S',YD_FCTY_TP_CFS_FLG,'X')" ).append("\n"); 
		query.append("                                             FROM MDM_YARD" ).append("\n"); 
		query.append("                                             WHERE YD_CD=I.ROUT_DEST_NOD_CD),'X')" ).append("\n"); 
		query.append("                 AND I.ROUT_DEST_NOD_CD  LIKE DECODE(@[del_t],'F','','T',''," ).append("\n"); 
		query.append("                                                      DECODE(@[del_n],''," ).append("\n"); 
		query.append("                                                           DECODE(@[del_t],'D',(SELECT REP_ZN_CD FROM MDM_LOCATION WHERE LOC_CD = @[del]),@[del]||'%')" ).append("\n"); 
		query.append("                                                      ,@[del_n])" ).append("\n"); 
		query.append("                                               )" ).append("\n"); 
		query.append("                 THEN 'Y'" ).append("\n"); 
		query.append("          ELSE 'X'" ).append("\n"); 
		query.append("     END) DEST_CHECK," ).append("\n"); 
		query.append("     (CASE WHEN NVL(@[por_n],@[por]) <> NVL(@[pol_n],NVL(@[pol], SUBSTR(POL1, 1, 5)))" ).append("\n"); 
		query.append("               AND NVL((SELECT 'Y' " ).append("\n"); 
		query.append("                   FROM BKG_TRO" ).append("\n"); 
		query.append("                   WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                   AND IO_BND_CD = 'O'" ).append("\n"); 
		query.append("                   AND CXL_FLG = 'N'" ).append("\n"); 
		query.append("                   AND ROWNUM = 1),'N') = 'N'" ).append("\n"); 
		query.append("               AND NVL((SELECT 'Y' " ).append("\n"); 
		query.append("                   FROM BKG_EUR_TRO" ).append("\n"); 
		query.append("                   WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                   AND IO_BND_CD = 'O'" ).append("\n"); 
		query.append("                   AND CXL_FLG = 'N'" ).append("\n"); 
		query.append("                   AND ROWNUM = 1),'N') = 'N'  " ).append("\n"); 
		query.append("               AND NVL((SELECT 'Y' FROM TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("                   WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                   AND TRSP_BND_CD = 'O'" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                   AND ROWNUM = 1),'N') = 'N'" ).append("\n"); 
		query.append("               AND NVL((SELECT 'Y' FROM TRS_TRSP_RAIL_BIL_ORD" ).append("\n"); 
		query.append("                   WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                   AND TRSP_BND_CD = 'O'" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                   AND ROWNUM = 1),'N') = 'N'" ).append("\n"); 
		query.append("           THEN DECODE(NVL(O.INLND_ROUT_BKG_FLG,'N'),'Y',DECODE(NVL(O.INLND_ROUT_TMP_FLG,'N'),'N','Y','N'),'B')" ).append("\n"); 
		query.append("           ELSE 'Y'" ).append("\n"); 
		query.append("    END) ORG_FLG_CHK," ).append("\n"); 
		query.append("    (CASE WHEN NVL(@[pod_n],NVL(@[pod], SUBSTR(POD_NODE, 1, 5))) <> NVL(@[del_n],@[del])" ).append("\n"); 
		query.append("               AND NVL((SELECT 'Y' " ).append("\n"); 
		query.append("                   FROM BKG_TRO" ).append("\n"); 
		query.append("                   WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                   AND IO_BND_CD = 'I'" ).append("\n"); 
		query.append("                   AND CXL_FLG = 'N'" ).append("\n"); 
		query.append("                   AND ROWNUM = 1),'N') = 'N'" ).append("\n"); 
		query.append("               AND NVL((SELECT 'Y' " ).append("\n"); 
		query.append("                   FROM BKG_EUR_TRO" ).append("\n"); 
		query.append("                   WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                   AND IO_BND_CD = 'I'" ).append("\n"); 
		query.append("                   AND CXL_FLG = 'N'" ).append("\n"); 
		query.append("                   AND ROWNUM = 1),'N') = 'N'  " ).append("\n"); 
		query.append("               AND NVL((SELECT 'Y' FROM TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("                   WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                   AND TRSP_BND_CD = 'I'" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                   AND ROWNUM = 1),'N') = 'N'" ).append("\n"); 
		query.append("               AND NVL((SELECT 'Y' FROM TRS_TRSP_RAIL_BIL_ORD" ).append("\n"); 
		query.append("                   WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                   AND TRSP_BND_CD = 'I'" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                   AND ROWNUM = 1),'N') = 'N'" ).append("\n"); 
		query.append("           THEN DECODE(NVL(I.INLND_ROUT_BKG_FLG,'N'),'Y',DECODE(NVL(I.INLND_ROUT_TMP_FLG,'N'),'N','Y','N'),'B')" ).append("\n"); 
		query.append("           ELSE 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     END) DEST_FLG_CHK," ).append("\n"); 
		query.append("     T.*, O.TRSP_MOD_CD OB_TRSP_MOD_CD, I.TRSP_MOD_CD IB_TRSP_MOD_CD," ).append("\n"); 
		query.append("     (CASE" ).append("\n"); 
		query.append("           WHEN DECODE(NVL(@[ob_str],'%'),'%',1,INSTR(NVL(PRD_GET_INLND_ROUT_STR_FNC(O.ROUT_ORG_NOD_CD,O.ROUT_DEST_NOD_CD,O.ROUT_SEQ),'X'),NVL(REGEXP_REPLACE(REPLACE(@[ob_str],'%',''),'-...-','-'),'X'))) >=1 " ).append("\n"); 
		query.append("            THEN 'Y'" ).append("\n"); 
		query.append("           ELSE 'X'" ).append("\n"); 
		query.append("     END) OB_SO_CHK," ).append("\n"); 
		query.append("     (CASE" ).append("\n"); 
		query.append("           WHEN DECODE(NVL(@[ib_str],'%'),'%',1,INSTR(NVL(PRD_GET_INLND_ROUT_STR_FNC(I.ROUT_ORG_NOD_CD,I.ROUT_DEST_NOD_CD,I.ROUT_SEQ),'X'),NVL(REGEXP_REPLACE(REPLACE(@[ib_str],'%',''),'-...-','-'),'X'))) >=1" ).append("\n"); 
		query.append("            THEN 'Y'" ).append("\n"); 
		query.append("           ELSE 'X'" ).append("\n"); 
		query.append("     END) IB_SO_CHK," ).append("\n"); 
		query.append("     (CASE " ).append("\n"); 
		query.append("           WHEN REPLACE(NVL(@[ob_str],'%'), '%', '') IS NULL THEN 'X'" ).append("\n"); 
		query.append("           ELSE NVL((SELECT 'Y_' || REGEXP_REPLACE(PRD_GET_INLND_ROUT_STR_FNC(M.ROUT_ORG_NOD_CD, M.ROUT_DEST_NOD_CD, M.ROUT_SEQ), '-..-.-', '-')" ).append("\n"); 
		query.append("                       FROM PRD_INLND_ROUT_MST M" ).append("\n"); 
		query.append("                          , PRD_NODE N" ).append("\n"); 
		query.append("                      WHERE M.ROUT_ORG_NOD_CD LIKE @[por] ||'%'" ).append("\n"); 
		query.append("                        AND M.ROUT_DEST_NOD_CD LIKE NVL(@[pol], SUBSTR(O.ROUT_DEST_NOD_CD, 1, 5)) ||'%'" ).append("\n"); 
		query.append("                       AND M.PCTL_IO_BND_CD = 'O'" ).append("\n"); 
		query.append("                       AND NVL(M.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                       AND M.ROUT_ORG_NOD_CD = N.NOD_CD" ).append("\n"); 
		query.append("                       AND N.NOD_TP_CD = DECODE(@[rcv_t], 'D', 'Z', 'S', 'S', DECODE(N.NOD_TP_CD, 'Z', 'X', N.NOD_TP_CD))" ).append("\n"); 
		query.append("                       AND PRD_GET_INLND_ROUT_STR_FNC(M.ROUT_ORG_NOD_CD, M.ROUT_DEST_NOD_CD, M.ROUT_SEQ) LIKE REGEXP_REPLACE(@[ob_str],'-...-','-') || '%'" ).append("\n"); 
		query.append("                       AND ROWNUM = 1)" ).append("\n"); 
		query.append("                , 'X')" ).append("\n"); 
		query.append("      END) OB_IRG_CHK," ).append("\n"); 
		query.append("     (CASE WHEN REPLACE(NVL(@[ib_str],'%'), '%', '') IS NULL THEN 'X'" ).append("\n"); 
		query.append("           ELSE NVL((SELECT 'Y_' || REGEXP_REPLACE(PRD_GET_INLND_ROUT_STR_FNC(M.ROUT_ORG_NOD_CD, M.ROUT_DEST_NOD_CD, M.ROUT_SEQ), '-..-.-', '-')" ).append("\n"); 
		query.append("                       FROM PRD_INLND_ROUT_MST M" ).append("\n"); 
		query.append("                          , PRD_NODE N" ).append("\n"); 
		query.append("                      WHERE M.ROUT_ORG_NOD_CD LIKE NVL(@[pod], SUBSTR(I.ROUT_ORG_NOD_CD,1,5)) ||'%'" ).append("\n"); 
		query.append("                        AND M.ROUT_DEST_NOD_CD LIKE @[del]||'%'" ).append("\n"); 
		query.append("                        AND M.PCTL_IO_BND_CD = 'I'" ).append("\n"); 
		query.append("                        AND NVL(M.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                        AND M.ROUT_DEST_NOD_CD = N.NOD_CD" ).append("\n"); 
		query.append("                        AND N.NOD_TP_CD = DECODE(@[del_t], 'D', 'Z', 'S', 'S', DECODE(N.NOD_TP_CD, 'Z', 'X', N.NOD_TP_CD))" ).append("\n"); 
		query.append("                        AND PRD_GET_INLND_ROUT_STR_FNC(M.ROUT_ORG_NOD_CD, M.ROUT_DEST_NOD_CD, M.ROUT_SEQ) LIKE REGEXP_REPLACE(@[ib_str],'-...-','-') || '%'" ).append("\n"); 
		query.append("                        AND ROWNUM = 1)" ).append("\n"); 
		query.append("                    , 'X')" ).append("\n"); 
		query.append("      END) IB_IRG_CHK," ).append("\n"); 
		query.append("	 (CASE 	WHEN @[rcv_t] = 'S' AND NVL(O.ROUT_SEQ,0) = 0 THEN NULL" ).append("\n"); 
		query.append("			WHEN LENGTH(NVL(@[m_pu],'X')) = 7 THEN @[m_pu]" ).append("\n"); 
		query.append("			WHEN (SELECT MTY_PKUP_RTN_YD_CD FROM PRD_PKUP_RTN_YD" ).append("\n"); 
		query.append("				  WHERE POR_DEL_CD = @[por]" ).append("\n"); 
		query.append("				  AND POL_POD_CD = NVL(@[pol], SUBSTR(POL1,1,5))" ).append("\n"); 
		query.append("				  AND IO_BND_CD IN ('O','B')" ).append("\n"); 
		query.append("				  AND NVL(DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("				  AND SPCL_CGO_CD IN (  DECODE(NVL(@[dg_spcl_flg],'N'),'Y','DG','AL'), DECODE(NVL(@[rf_spcl_flg],'N'),'Y','RF','AL'), DECODE(NVL(@[rf_spcl_flg],'N')||NVL(@[dg_spcl_flg],'N'),'NN','DR'), 'AL')" ).append("\n"); 
		query.append("				  AND VSL_SLAN_CD IN (N1ST_LANE_CD,'ALL')" ).append("\n"); 
		query.append("			#if($arr_tpsz.size() > 0)  " ).append("\n"); 
		query.append("				  AND NVL(CNTR_TP_CD,'AL') || NVL(CNTR_SZ_CD, 'AL') IN ('ALAL'" ).append("\n"); 
		query.append("					#foreach($code IN ${arr_tpsz})" ).append("\n"); 
		query.append("						 ,'$code'" ).append("\n"); 
		query.append("					#end " ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("			#end 				  " ).append("\n"); 
		query.append("				  AND ROWNUM =1) IS NOT NULL" ).append("\n"); 
		query.append("			  THEN (SELECT MTY_PKUP_RTN_YD_CD " ).append("\n"); 
		query.append("				  FROM (SELECT MTY_PKUP_RTN_YD_CD, POL_POD_CD, VSL_SLAN_CD, DECODE(CNTR_TP_CD||CNTR_SZ_CD,'ALAL',100,0) + DECODE(VSL_SLAN_CD,'ALL',10,0)+DECODE(SPCL_CGO_CD,'AL',1,0) WGT" ).append("\n"); 
		query.append("						FROM PRD_PKUP_RTN_YD" ).append("\n"); 
		query.append("						WHERE POR_DEL_CD = @[por]" ).append("\n"); 
		query.append("						AND IO_BND_CD IN ('O','B')" ).append("\n"); 
		query.append("						AND NVL(DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("						AND SPCL_CGO_CD IN ( DECODE(NVL(@[dg_spcl_flg],'N'),'Y','DG','AL'),DECODE(NVL(@[rf_spcl_flg],'N'),'Y','RF','AL'), DECODE(NVL(@[rf_spcl_flg],'N')||NVL(@[dg_spcl_flg],'N'),'NN','DR'), 'AL')" ).append("\n"); 
		query.append("					#if($arr_tpsz.size() > 0)  " ).append("\n"); 
		query.append("						AND NVL(CNTR_TP_CD,'AL') || NVL(CNTR_SZ_CD, 'AL') IN ('ALAL'" ).append("\n"); 
		query.append("							#foreach($code IN ${arr_tpsz})" ).append("\n"); 
		query.append("								 ,'$code'" ).append("\n"); 
		query.append("							#end " ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("					#end							" ).append("\n"); 
		query.append("						ORDER BY WGT" ).append("\n"); 
		query.append("				  )" ).append("\n"); 
		query.append("				  WHERE VSL_SLAN_CD IN (N1ST_LANE_CD,'ALL')" ).append("\n"); 
		query.append("					AND POL_POD_CD = NVL(@[pol], SUBSTR(POL1,1,5)				" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("					AND ROWNUM =1)" ).append("\n"); 
		query.append("			WHEN @[rcv_t] = 'D' THEN (SELECT Z.REP_YD_CD FROM MDM_ZONE Z WHERE Z.ZN_CD = NVL(I.ROUT_ORG_NOD_CD,T.POD_NODE))" ).append("\n"); 
		query.append("			ELSE (SELECT L.MTY_PKUP_YD_CD FROM MDM_LOCATION L WHERE L.LOC_CD = @[por])" ).append("\n"); 
		query.append("	 END) MTPU_CY,                         " ).append("\n"); 
		query.append("	 (CASE 	WHEN @[del_t] = 'S' AND NVL(I.ROUT_SEQ,0) = 0 THEN NULL" ).append("\n"); 
		query.append("			WHEN (SELECT MTY_PKUP_RTN_YD_CD FROM PRD_PKUP_RTN_YD" ).append("\n"); 
		query.append("				  WHERE POR_DEL_CD = @[del]" ).append("\n"); 
		query.append("				  AND POL_POD_CD = NVL(@[pod], SUBSTR(NVL(POD4, NVL(POD3, NVL(POD2, POD1))) ,1,5))" ).append("\n"); 
		query.append("				  AND IO_BND_CD = 'I'" ).append("\n"); 
		query.append("				  AND NVL(DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("				  AND SPCL_CGO_CD IN (  DECODE(NVL(@[dg_spcl_flg],'N'),'Y','DG','AL'), DECODE(NVL(@[rf_spcl_flg],'N'),'Y','RF','AL'), DECODE(NVL(@[rf_spcl_flg],'N')||NVL(@[dg_spcl_flg],'N'),'NN','DR'), 'AL')" ).append("\n"); 
		query.append("				  AND VSL_SLAN_CD IN (NVL(N4TH_LANE_CD, NVL(N3RD_LANE_CD, NVL(N2ND_LANE_CD, N1ST_LANE_CD))),'ALL')" ).append("\n"); 
		query.append("			#if($arr_tpsz.size() > 0)  " ).append("\n"); 
		query.append("				  AND NVL(CNTR_TP_CD,'AL') || NVL(CNTR_SZ_CD, 'AL') IN ('ALAL'" ).append("\n"); 
		query.append("					#foreach($code IN ${arr_tpsz})" ).append("\n"); 
		query.append("						 ,'$code'" ).append("\n"); 
		query.append("					#end " ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("			#end 					  " ).append("\n"); 
		query.append("				  AND ROWNUM =1) IS NOT NULL" ).append("\n"); 
		query.append("			  THEN (SELECT MTY_PKUP_RTN_YD_CD " ).append("\n"); 
		query.append("				  FROM (SELECT MTY_PKUP_RTN_YD_CD, POL_POD_CD, VSL_SLAN_CD, DECODE(VSL_SLAN_CD,'ALL',10,0)+DECODE(SPCL_CGO_CD,'AL',1,0) WGT" ).append("\n"); 
		query.append("						FROM PRD_PKUP_RTN_YD" ).append("\n"); 
		query.append("						WHERE POR_DEL_CD = @[del]" ).append("\n"); 
		query.append("						AND IO_BND_CD = 'I'" ).append("\n"); 
		query.append("						AND NVL(DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("						AND SPCL_CGO_CD IN ( DECODE(NVL(@[dg_spcl_flg],'N'),'Y','DG','AL'),DECODE(NVL(@[rf_spcl_flg],'N'),'Y','RF','AL'), DECODE(NVL(@[rf_spcl_flg],'N')||NVL(@[dg_spcl_flg],'N'),'NN','DR'), 'AL')" ).append("\n"); 
		query.append("					#if($arr_tpsz.size() > 0)  " ).append("\n"); 
		query.append("						AND NVL(CNTR_TP_CD,'AL') || NVL(CNTR_SZ_CD, 'AL') IN ('ALAL'" ).append("\n"); 
		query.append("							#foreach($code IN ${arr_tpsz})" ).append("\n"); 
		query.append("								 ,'$code'" ).append("\n"); 
		query.append("							#end " ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("					#end						" ).append("\n"); 
		query.append("						ORDER BY WGT" ).append("\n"); 
		query.append("				  )" ).append("\n"); 
		query.append("			  WHERE VSL_SLAN_CD IN (NVL(N4TH_LANE_CD, NVL(N3RD_LANE_CD, NVL(N2ND_LANE_CD, N1ST_LANE_CD))),'ALL')" ).append("\n"); 
		query.append("				AND POL_POD_CD = NVL(@[pod], SUBSTR(NVL(POD4, NVL(POD3, NVL(POD2, POD1))) ,1,5))" ).append("\n"); 
		query.append("				AND ROWNUM =1)" ).append("\n"); 
		query.append("			WHEN @[del_t] ='D' THEN (SELECT Z.REP_YD_CD FROM MDM_ZONE Z WHERE Z.ZN_CD = NVL(I.ROUT_DEST_NOD_CD,T.POD_NODE))" ).append("\n"); 
		query.append("			ELSE (SELECT NVL(L.EQ_RTN_YD_CD, L.MTY_PKUP_YD_CD) FROM MDM_LOCATION L WHERE L.LOC_CD =@[del]) " ).append("\n"); 
		query.append("	 END) MTRTN_CY" ).append("\n"); 
		query.append("        FROM ( " ).append("\n"); 
		query.append("        SELECT C.*," ).append("\n"); 
		query.append("		DECODE(N1ST_SVC_TP,'O'," ).append("\n"); 
		query.append("			NVL(DECODE(SIGN(INSTR(@[ocn_str],SUBSTR(POL1,1,5),1,1)),1,SUBSTR(@[ocn_str],INSTR(@[ocn_str],SUBSTR(POL1,1,5),1,1),7)),POL1),POL1) POL1_,  " ).append("\n"); 
		query.append("		(SELECT YD_FCTY_TP_CFS_FLG " ).append("\n"); 
		query.append(" 		FROM MDM_YARD " ).append("\n"); 
		query.append(" 		WHERE YD_CD=DECODE(N1ST_SVC_TP,'O'," ).append("\n"); 
		query.append("				NVL(DECODE(SIGN(INSTR(@[ocn_str],SUBSTR(POL1,1,5),1,1)),1,SUBSTR(@[ocn_str],INSTR(@[ocn_str],SUBSTR(POL1,1,5),1,1),7)),POL1),POL1) ) POL1_S, " ).append("\n"); 
		query.append("        DECODE(SIGN(INSTR(@[ocn_str],SUBSTR(POD4,1,5),-1)),1,SUBSTR(@[ocn_str],INSTR(@[ocn_str],SUBSTR(POD4,1,5),-1),7),POD4) POD4_," ).append("\n"); 
		query.append("        NVL(DECODE(SIGN(INSTR(@[ocn_str],SUBSTR(POD_NODE,1,5),-1)),1,SUBSTR(@[ocn_str],INSTR(@[ocn_str],SUBSTR(POD_NODE,1,5),-1),7),POD_NODE), POD_NODE) POD_NODE_," ).append("\n"); 
		query.append("        (SELECT YD_FCTY_TP_CFS_FLG" ).append("\n"); 
		query.append("         FROM MDM_YARD" ).append("\n"); 
		query.append("         WHERE YD_CD = NVL(DECODE(SIGN(INSTR(@[ocn_str],SUBSTR(POD_NODE,1,5),-1)),1,SUBSTR(@[ocn_str],INSTR(@[ocn_str],SUBSTR(POD_NODE,1,5),-1),7),POD_NODE), POD_NODE)" ).append("\n"); 
		query.append("		) POD_NODE_S," ).append("\n"); 
		query.append("        (CASE WHEN POD_NODE IS NULL THEN 'X'" ).append("\n"); 
		query.append("              WHEN LNK_KNT = 4 AND ( POL4 IS NULL OR POD4 IS NULL OR POLT4 IS NULL OR PODT4 IS NULL" ).append("\n"); 
		query.append("                                    OR ( N4TH_SVC_TP <> 'O' AND ( VVD4 IS NULL OR CRR4 IS NULL OR POL_SEQ4 IS NULL OR  POD_SEQ4 IS NULL) )" ).append("\n"); 
		query.append("                                    OR ( POL3 IS NULL OR POD3 IS NULL OR POLT3 IS NULL OR PODT3 IS NULL )" ).append("\n"); 
		query.append("                                    OR ( N3RD_SVC_TP <> 'O' AND ( VVD3 IS NULL OR CRR3 IS NULL OR POL_SEQ3 IS NULL OR  POD_SEQ3 IS NULL) )" ).append("\n"); 
		query.append("                                    OR ( POL2 IS NULL OR POD2 IS NULL OR POLT2 IS NULL OR PODT2 IS NULL )" ).append("\n"); 
		query.append("                                    OR ( N2ND_SVC_TP <> 'O' AND ( VVD2 IS NULL OR CRR2 IS NULL OR POL_SEQ2 IS NULL OR  POD_SEQ2 IS NULL) )" ).append("\n"); 
		query.append("                                    OR ( POL1 IS NULL OR POD1 IS NULL OR POLT1 IS NULL OR PODT1 IS NULL )" ).append("\n"); 
		query.append("                                    OR ( N1ST_SVC_TP <> 'O' AND ( VVD1 IS NULL OR CRR1 IS NULL OR POL_SEQ1 IS NULL OR  POD_SEQ1 IS NULL) ) )" ).append("\n"); 
		query.append("                   THEN 'X'" ).append("\n"); 
		query.append("              WHEN LNK_KNT = 3 AND ( POL3 IS NULL OR POD3 IS NULL OR POLT3 IS NULL OR PODT3 IS NULL" ).append("\n"); 
		query.append("                                    OR ( N3RD_SVC_TP <> 'O' AND ( VVD3 IS NULL OR CRR3 IS NULL OR POL_SEQ3 IS NULL OR  POD_SEQ3 IS NULL) )" ).append("\n"); 
		query.append("                                    OR ( POL2 IS NULL OR POD2 IS NULL OR POLT2 IS NULL OR PODT2 IS NULL )" ).append("\n"); 
		query.append("                                    OR ( N2ND_SVC_TP <> 'O' AND ( VVD2 IS NULL OR CRR2 IS NULL OR POL_SEQ2 IS NULL OR  POD_SEQ2 IS NULL) )" ).append("\n"); 
		query.append("                                    OR ( POL1 IS NULL OR POD1 IS NULL OR POLT1 IS NULL OR PODT1 IS NULL )" ).append("\n"); 
		query.append("                                    OR ( N1ST_SVC_TP <> 'O' AND ( VVD1 IS NULL OR CRR1 IS NULL OR POL_SEQ1 IS NULL OR  POD_SEQ1 IS NULL) ) )" ).append("\n"); 
		query.append("                   THEN 'X'" ).append("\n"); 
		query.append("              WHEN LNK_KNT = 2 AND ( POL2 IS NULL OR POD2 IS NULL OR POLT2 IS NULL OR PODT2 IS NULL" ).append("\n"); 
		query.append("                                    OR ( N2ND_SVC_TP <> 'O' AND ( VVD2 IS NULL OR CRR2 IS NULL OR POL_SEQ2 IS NULL OR  POD_SEQ2 IS NULL) )" ).append("\n"); 
		query.append("                                    OR ( POL1 IS NULL OR POD1 IS NULL OR POLT1 IS NULL OR PODT1 IS NULL )" ).append("\n"); 
		query.append("                                    OR ( N1ST_SVC_TP <> 'O' AND ( VVD1 IS NULL OR CRR1 IS NULL OR POL_SEQ1 IS NULL OR  POD_SEQ1 IS NULL) ) )" ).append("\n"); 
		query.append("                   THEN 'X'" ).append("\n"); 
		query.append("              WHEN LNK_KNT = 1 AND ( POL1 IS NULL OR POD1 IS NULL OR POLT1 IS NULL OR PODT1 IS NULL" ).append("\n"); 
		query.append("                                    OR ( N1ST_SVC_TP <> 'O' AND ( VVD1 IS NULL OR CRR1 IS NULL OR POL_SEQ1 IS NULL OR  POD_SEQ1 IS NULL) ) )" ).append("\n"); 
		query.append("                   THEN 'X'" ).append("\n"); 
		query.append("            ELSE 'Y'" ).append("\n"); 
		query.append("        END ) CHECK_ROUT" ).append("\n"); 
		query.append("	    ,(" ).append("\n"); 
		query.append("            SELECT VSL_CD||SKD_VOY_NO||SKD_DIR_CD " ).append("\n"); 
		query.append("            FROM VSK_VSL_SKD" ).append("\n"); 
		query.append("            WHERE (VSL_CD, SKD_VOY_NO, SKD_DIR_CD)" ).append("\n"); 
		query.append("               IN ( (SUBSTR(@[vvd1],1,4), SUBSTR(@[vvd1],5,4), SUBSTR(@[vvd1],9,1))" ).append("\n"); 
		query.append("                   ,(SUBSTR(@[vvd2],1,4), SUBSTR(@[vvd2],5,4), SUBSTR(@[vvd2],9,1))" ).append("\n"); 
		query.append("                   ,(SUBSTR(@[vvd3],1,4), SUBSTR(@[vvd3],5,4), SUBSTR(@[vvd3],9,1))" ).append("\n"); 
		query.append("                   ,(SUBSTR(@[vvd4],1,4), SUBSTR(@[vvd4],5,4), SUBSTR(@[vvd4],9,1))" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("            AND SKD_STS_CD = 'CLO'" ).append("\n"); 
		query.append("              AND ROWNUM = 1" ).append("\n"); 
		query.append("          )  STS_CHECK" ).append("\n"); 
		query.append("        ,UPD_IND_CD OCN_FLG" ).append("\n"); 
		query.append("        ,(SELECT REP_ZN_CD FROM MDM_LOCATION WHERE LOC_CD = @[por]) OB_REP_ZN_CD --20100406 " ).append("\n"); 
		query.append("        ,(SELECT REP_ZN_CD FROM MDM_LOCATION WHERE LOC_CD = @[del]) IB_REP_ZN_CD --20100406 " ).append("\n"); 
		query.append("        FROM ( -- C" ).append("\n"); 
		query.append("            SELECT /*+ NO_MERGE(B)  */" ).append("\n"); 
		query.append("            B.*," ).append("\n"); 
		query.append("            TRIM(DECODE(INSTR(SKD_STR,'CCC'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'CCC')+3,14))) CCT," ).append("\n"); 
		query.append("            TRIM(DECODE(INSTR(SKD_STR,'POL1'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POL1')+4,7))) POL1," ).append("\n"); 
		query.append("            TRIM(DECODE(INSTR(SKD_STR,'POD1'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD1')+4,7))) POD1," ).append("\n"); 
		query.append("            TRIM(DECODE(INSTR(SKD_STR,'POLT1'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POLT1')+5,14))) POLT1," ).append("\n"); 
		query.append("            TRIM(DECODE(INSTR(SKD_STR,'PODT1'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'PODT1')+5,14))) PODT1," ).append("\n"); 
		query.append("            TRIM(DECODE(INSTR(SKD_STR,'VVD1'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'VVD1')+4,9))) VVD1," ).append("\n"); 
		query.append("            TRIM(DECODE(INSTR(SKD_STR,'CRR1'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'CRR1')+4,4))) CRR1," ).append("\n"); 
		query.append("            TRIM(DECODE(INSTR(SKD_STR,'POL_SEQ1'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POL_SEQ1')+8,2))) POL_SEQ1," ).append("\n"); 
		query.append("            TRIM(DECODE(INSTR(SKD_STR,'POD_SEQ1'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD_SEQ1')+8,2))) POD_SEQ1," ).append("\n"); 
		query.append("            TRIM(DECODE(INSTR(SKD_STR,'POL2'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POL2')+4,7))) POL2," ).append("\n"); 
		query.append("            TRIM(DECODE(INSTR(SKD_STR,'POD2'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD2')+4,7))) POD2," ).append("\n"); 
		query.append("            TRIM(DECODE(INSTR(SKD_STR,'POLT2'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POLT2')+5,14))) POLT2," ).append("\n"); 
		query.append("            TRIM(DECODE(INSTR(SKD_STR,'PODT2'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'PODT2')+5,14))) PODT2," ).append("\n"); 
		query.append("            TRIM(DECODE(INSTR(SKD_STR,'VVD2'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'VVD2')+4,9))) VVD2," ).append("\n"); 
		query.append("            TRIM(DECODE(INSTR(SKD_STR,'CRR2'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'CRR2')+4,4))) CRR2," ).append("\n"); 
		query.append("            TRIM(DECODE(INSTR(SKD_STR,'POL_SEQ2'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POL_SEQ2')+8,2))) POL_SEQ2," ).append("\n"); 
		query.append("            TRIM(DECODE(INSTR(SKD_STR,'POD_SEQ2'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD_SEQ2')+8,2))) POD_SEQ2," ).append("\n"); 
		query.append("            TRIM(DECODE(INSTR(SKD_STR,'POL3'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POL3')+4,7))) POL3," ).append("\n"); 
		query.append("            TRIM(DECODE(INSTR(SKD_STR,'POD3'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD3')+4,7))) POD3," ).append("\n"); 
		query.append("            TRIM(DECODE(INSTR(SKD_STR,'POLT3'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POLT3')+5,14))) POLT3," ).append("\n"); 
		query.append("            TRIM(DECODE(INSTR(SKD_STR,'PODT3'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'PODT3')+5,14))) PODT3," ).append("\n"); 
		query.append("            TRIM(DECODE(INSTR(SKD_STR,'VVD3'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'VVD3')+4,9))) VVD3," ).append("\n"); 
		query.append("            TRIM(DECODE(INSTR(SKD_STR,'CRR3'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'CRR3')+4,4))) CRR3," ).append("\n"); 
		query.append("            TRIM(DECODE(INSTR(SKD_STR,'POL_SEQ3'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POL_SEQ3')+8,2))) POL_SEQ3," ).append("\n"); 
		query.append("            TRIM(DECODE(INSTR(SKD_STR,'POD_SEQ3'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD_SEQ3')+8,2))) POD_SEQ3," ).append("\n"); 
		query.append("            TRIM(DECODE(INSTR(SKD_STR,'POL4'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POL4')+4,7))) POL4," ).append("\n"); 
		query.append("            TRIM(DECODE(INSTR(SKD_STR,'POD4'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD4')+4,7))) POD4," ).append("\n"); 
		query.append("            TRIM(DECODE(INSTR(SKD_STR,'POLT4'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POLT4')+5,14))) POLT4," ).append("\n"); 
		query.append("            TRIM(DECODE(INSTR(SKD_STR,'PODT4'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'PODT4')+5,14))) PODT4," ).append("\n"); 
		query.append("            TRIM(DECODE(INSTR(SKD_STR,'VVD4'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'VVD4')+4,9))) VVD4," ).append("\n"); 
		query.append("            TRIM(DECODE(INSTR(SKD_STR,'CRR4'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'CRR4')+4,4))) CRR4," ).append("\n"); 
		query.append("            TRIM(DECODE(INSTR(SKD_STR,'POL_SEQ4'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POL_SEQ4')+8,2))) POL_SEQ4," ).append("\n"); 
		query.append("            TRIM(DECODE(INSTR(SKD_STR,'POD_SEQ4'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD_SEQ4')+8,2))) POD_SEQ4," ).append("\n"); 
		query.append("            TRIM(DECODE(LNK_KNT,4,TRIM(DECODE(INSTR(SKD_STR,'POD4'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD4')+4,7)))," ).append("\n"); 
		query.append("                           3,TRIM(DECODE(INSTR(SKD_STR,'POD3'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD3')+4,7)))," ).append("\n"); 
		query.append("                           2,TRIM(DECODE(INSTR(SKD_STR,'POD2'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD2')+4,7)))," ).append("\n"); 
		query.append("                           TRIM(DECODE(INSTR(SKD_STR,'POD1'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD1')+4,7))))) POD_NODE" ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("                SELECT -- B OCN 유무" ).append("\n"); 
		query.append("                '1' HUB_COUNT, ORG_LOC_CD, DEST_LOC_CD, ROUT_SEQ, LNK_KNT," ).append("\n"); 
		query.append("                N1ST_LANE_CD, N2ND_LANE_CD, N3RD_LANE_CD, N4TH_LANE_CD, N2ND_POL_CD,  N3RD_POL_CD, N4TH_POL_CD," ).append("\n"); 
		query.append("                N1.VSL_SVC_TP_CD N1ST_SVC_TP," ).append("\n"); 
		query.append("                N2.VSL_SVC_TP_CD N2ND_SVC_TP," ).append("\n"); 
		query.append("                N3.VSL_SVC_TP_CD N3RD_SVC_TP," ).append("\n"); 
		query.append("                N4.VSL_SVC_TP_CD N4TH_SVC_TP," ).append("\n"); 
		query.append("                N1ST_TZTM_HRS, N2ND_TZTM_HRS, N3RD_TZTM_HRS, N4TH_TZTM_HRS," ).append("\n"); 
		query.append("                PRD_GET_OCN_SKD_FNC(@[skd_date], @[skd_type], ORG_LOC_CD, DEST_LOC_CD," ).append("\n"); 
		query.append("                    NVL(DECODE(N1.VSL_SVC_TP_CD, 'O',DECODE(@[vvd1],'',@[pol_n]),@[pol_n]),N1ST_POL_CD), @[n1st_pol_dc_seq], " ).append("\n"); 
		query.append("                    NVL(DECODE(LNK_KNT,1,DECODE(N1.VSL_SVC_TP_CD, 'O',DECODE(@[vvd1], '',@[pod_n]),@[pod_n])),N1ST_POD_CD)," ).append("\n"); 
		query.append("                    @[n1st_pod_dc_seq], N1ST_LANE_CD, N1ST_SKD_DIR_CD, N1.VSL_SVC_TP_CD, @[vvd1]," ).append("\n"); 
		query.append("                    N2ND_POL_CD, @[n2nd_pol_dc_seq], " ).append("\n"); 
		query.append("                    NVL(DECODE(LNK_KNT,2,DECODE(N2.VSL_SVC_TP_CD, 'O',DECODE(@[vvd2], '',@[pod_n]),@[pod_n])),N2ND_POD_CD)," ).append("\n"); 
		query.append("                    @[n2nd_pod_dc_seq], N2ND_LANE_CD, N2ND_SKD_DIR_CD, N2.VSL_SVC_TP_CD, @[vvd2], " ).append("\n"); 
		query.append("                    N3RD_POL_CD, @[n3rd_pol_dc_seq], " ).append("\n"); 
		query.append("                    NVL(DECODE(LNK_KNT,3,DECODE(N3.VSL_SVC_TP_CD, 'O',DECODE(@[vvd3], '',@[pod_n]),@[pod_n])),N3RD_POD_CD)," ).append("\n"); 
		query.append("                    @[n3rd_pod_dc_seq], N3RD_LANE_CD, N3RD_SKD_DIR_CD, N3.VSL_SVC_TP_CD, @[vvd3]," ).append("\n"); 
		query.append("                    N4TH_POL_CD, @[n4th_pol_dc_seq], " ).append("\n"); 
		query.append("                    NVL(DECODE(LNK_KNT,4,DECODE(N4.VSL_SVC_TP_CD, 'O',DECODE(@[vvd4], '',@[pod_n]),@[pod_n])),DEST_LOC_CD)," ).append("\n"); 
		query.append("                    @[n4th_pod_dc_seq], N4TH_LANE_CD, N4TH_SKD_DIR_CD, N4.VSL_SVC_TP_CD, @[vvd4]," ).append("\n"); 
		query.append("                NVL(@[cgo_tp],'AL'),'N') SKD_STR" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				,UPD_IND_CD	" ).append("\n"); 
		query.append("                , (CASE WHEN INSTR(REGEXP_REPLACE(ORG_LOC_CD||'-'||N2ND_POL_CD||'-'||N3RD_POL_CD||'-'||N4TH_POL_CD||'-'||DEST_LOC_CD,'[-]{4}|[-]{3}|[-]{2}','-')," ).append("\n"); 
		query.append("                          NVL(SUBSTR(REGEXP_SUBSTR(@[ocn_str],'[-%].{7}[-%]',1,1),2,5),ORG_LOC_CD)) <= 0" ).append("\n"); 
		query.append("                             THEN 'X'" ).append("\n"); 
		query.append("                        WHEN INSTR(REGEXP_REPLACE(ORG_LOC_CD||'-'||N2ND_POL_CD||'-'||N3RD_POL_CD||'-'||N4TH_POL_CD||'-'||DEST_LOC_CD,'[-]{4}|[-]{3}|[-]{2}','-')," ).append("\n"); 
		query.append("                          NVL(SUBSTR(REGEXP_SUBSTR(@[ocn_str],'[-%].{7}[-%]',1,2),2,5),ORG_LOC_CD)) <= 0" ).append("\n"); 
		query.append("                             THEN 'X'" ).append("\n"); 
		query.append("                        WHEN INSTR(REGEXP_REPLACE(ORG_LOC_CD||'-'||N2ND_POL_CD||'-'||N3RD_POL_CD||'-'||N4TH_POL_CD||'-'||DEST_LOC_CD,'[-]{4}|[-]{3}|[-]{2}','-')," ).append("\n"); 
		query.append("                          NVL(SUBSTR(REGEXP_SUBSTR(@[ocn_str],'[-%].{7}[-%]',1,3),2,5),ORG_LOC_CD)) <= 0" ).append("\n"); 
		query.append("                             THEN 'X'" ).append("\n"); 
		query.append("                        WHEN INSTR(REGEXP_REPLACE(ORG_LOC_CD||'-'||N2ND_POL_CD||'-'||N3RD_POL_CD||'-'||N4TH_POL_CD||'-'||DEST_LOC_CD,'[-]{4}|[-]{3}|[-]{2}','-')," ).append("\n"); 
		query.append("                          NVL(SUBSTR(REGEXP_SUBSTR(@[ocn_str],'[-%].{7}[-%]',1,4),2,5),ORG_LOC_CD)) <= 0" ).append("\n"); 
		query.append("                             THEN 'X'" ).append("\n"); 
		query.append("                        WHEN INSTR(REGEXP_REPLACE(ORG_LOC_CD||'-'||N2ND_POL_CD||'-'||N3RD_POL_CD||'-'||N4TH_POL_CD||'-'||DEST_LOC_CD,'[-]{4}|[-]{3}|[-]{2}','-')," ).append("\n"); 
		query.append("                          NVL(SUBSTR(REGEXP_SUBSTR(@[ocn_str],'[-%].{7}[-%]',1,5),2,5),ORG_LOC_CD)) <= 0" ).append("\n"); 
		query.append("                             THEN 'X'" ).append("\n"); 
		query.append("                        WHEN INSTR(REGEXP_REPLACE(ORG_LOC_CD||'-'||N2ND_POL_CD||'-'||N3RD_POL_CD||'-'||N4TH_POL_CD||'-'||DEST_LOC_CD,'[-]{4}|[-]{3}|[-]{2}','-')," ).append("\n"); 
		query.append("                          NVL(SUBSTR(REGEXP_SUBSTR(@[ocn_str],'[-%].{7}[-%]',1,6),2,5),ORG_LOC_CD)) <= 0" ).append("\n"); 
		query.append("                             THEN 'X'" ).append("\n"); 
		query.append("                        WHEN INSTR(REGEXP_REPLACE(ORG_LOC_CD||'-'||N2ND_POL_CD||'-'||N3RD_POL_CD||'-'||N4TH_POL_CD||'-'||DEST_LOC_CD,'[-]{4}|[-]{3}|[-]{2}','-')," ).append("\n"); 
		query.append("                          NVL(SUBSTR(REGEXP_SUBSTR(@[ocn_str],'[-%].{7}[-%]',1,7),2,5),ORG_LOC_CD)) <= 0" ).append("\n"); 
		query.append("                             THEN 'X'" ).append("\n"); 
		query.append("                        WHEN INSTR(REGEXP_REPLACE(ORG_LOC_CD||'-'||N2ND_POL_CD||'-'||N3RD_POL_CD||'-'||N4TH_POL_CD||'-'||DEST_LOC_CD,'[-]{4}|[-]{3}|[-]{2}','-')," ).append("\n"); 
		query.append("                          DECODE(NVL(SUBSTR(REGEXP_SUBSTR(@[ocn_str],'.{7}-WD-.-...-.{7}',1,1),1,5),'X'),NVL(SUBSTR(REGEXP_SUBSTR(@[ocn_str],'.{7}-WD-.-...-.{7}',1,1),18,5),'X'),ORG_LOC_CD," ).append("\n"); 
		query.append("                           SUBSTR(REGEXP_SUBSTR(@[ocn_str],'.{7}-WD-.-...-.{7}',1,1),1,5)||'-'||SUBSTR(REGEXP_SUBSTR(@[ocn_str],'.{7}-WD-.-...-.{7}',1,1),18,5))) <= 0" ).append("\n"); 
		query.append("                             THEN 'X'" ).append("\n"); 
		query.append("                        WHEN INSTR(REGEXP_REPLACE(ORG_LOC_CD||'-'||N2ND_POL_CD||'-'||N3RD_POL_CD||'-'||N4TH_POL_CD||'-'||DEST_LOC_CD,'[-]{4}|[-]{3}|[-]{2}','-')," ).append("\n"); 
		query.append("                          DECODE(NVL(SUBSTR(REGEXP_SUBSTR(@[ocn_str],'.{7}-WD-.-...-.{7}',1,2),1,5),'X'),NVL(SUBSTR(REGEXP_SUBSTR(@[ocn_str],'.{7}-WD-.-...-.{7}',1,2),18,5),'X'),ORG_LOC_CD," ).append("\n"); 
		query.append("                           SUBSTR(REGEXP_SUBSTR(@[ocn_str],'.{7}-WD-.-...-.{7}',1,2),1,5)||'-'||SUBSTR(REGEXP_SUBSTR(@[ocn_str],'.{7}-WD-.-...-.{7}',1,2),18,5))) <= 0" ).append("\n"); 
		query.append("                             THEN 'X'" ).append("\n"); 
		query.append("                        WHEN INSTR(REGEXP_REPLACE(ORG_LOC_CD||'-'||N2ND_POL_CD||'-'||N3RD_POL_CD||'-'||N4TH_POL_CD||'-'||DEST_LOC_CD,'[-]{4}|[-]{3}|[-]{2}','-')," ).append("\n"); 
		query.append("                          DECODE(NVL(SUBSTR(REGEXP_SUBSTR(@[ocn_str],'.{7}-WD-.-...-.{7}',1,3),1,5),'X'),NVL(SUBSTR(REGEXP_SUBSTR(@[ocn_str],'.{7}-WD-.-...-.{7}',1,3),18,5),'X'),ORG_LOC_CD," ).append("\n"); 
		query.append("                           SUBSTR(REGEXP_SUBSTR(@[ocn_str],'.{7}-WD-.-...-.{7}',1,3),1,5)||'-'||SUBSTR(REGEXP_SUBSTR(@[ocn_str],'.{7}-WD-.-...-.{7}',1,3),18,5))) <= 0" ).append("\n"); 
		query.append("                             THEN 'X'" ).append("\n"); 
		query.append("                        WHEN NVL(DECODE(SUBSTR(REGEXP_SUBSTR(@[ocn_str],'.{7}-WD-.-...-.{7}',1,1),1,5)||'-'||SUBSTR(REGEXP_SUBSTR(@[ocn_str],'.{7}-WD-.-...-.{7}',1,1),18,5)," ).append("\n"); 
		query.append("                                                     ORG_LOC_CD||'-'||N1ST_POD_CD,N1.VSL_SVC_TP_CD," ).append("\n"); 
		query.append("                                                     N2ND_POL_CD||'-'||N2ND_POD_CD,N2.VSL_SVC_TP_CD," ).append("\n"); 
		query.append("                                                     N3RD_POL_CD||'-'||N3RD_POD_CD,N3.VSL_SVC_TP_CD," ).append("\n"); 
		query.append("                                                     N4TH_POL_CD||'-'||DEST_LOC_CD,N4.VSL_SVC_TP_CD),'O') <> 'O'" ).append("\n"); 
		query.append("                             THEN 'X'" ).append("\n"); 
		query.append("                        WHEN NVL(DECODE(SUBSTR(REGEXP_SUBSTR(@[ocn_str],'.{7}-WD-.-...-.{7}',1,2),1,5)||'-'||SUBSTR(REGEXP_SUBSTR(@[ocn_str],'.{7}-WD-.-...-.{7}',1,2),18,5)," ).append("\n"); 
		query.append("                                                     ORG_LOC_CD||'-'||N1ST_POD_CD,N1.VSL_SVC_TP_CD," ).append("\n"); 
		query.append("                                                     N2ND_POL_CD||'-'||N2ND_POD_CD,N2.VSL_SVC_TP_CD," ).append("\n"); 
		query.append("                                                     N3RD_POL_CD||'-'||N3RD_POD_CD,N3.VSL_SVC_TP_CD," ).append("\n"); 
		query.append("                                                     N4TH_POL_CD||'-'||DEST_LOC_CD,N4.VSL_SVC_TP_CD),'O') <> 'O'" ).append("\n"); 
		query.append("                             THEN 'X'" ).append("\n"); 
		query.append("                        WHEN NVL(DECODE(SUBSTR(REGEXP_SUBSTR(@[ocn_str],'.{7}-WD-.-...-.{7}',1,3),1,5)||'-'||SUBSTR(REGEXP_SUBSTR(@[ocn_str],'.{7}-WD-.-...-.{7}',1,3),18,5)," ).append("\n"); 
		query.append("                                                     ORG_LOC_CD||'-'||N1ST_POD_CD,N1.VSL_SVC_TP_CD," ).append("\n"); 
		query.append("                                                     N2ND_POL_CD||'-'||N2ND_POD_CD,N2.VSL_SVC_TP_CD," ).append("\n"); 
		query.append("                                                     N3RD_POL_CD||'-'||N3RD_POD_CD,N3.VSL_SVC_TP_CD," ).append("\n"); 
		query.append("                                                     N4TH_POL_CD||'-'||DEST_LOC_CD,N4.VSL_SVC_TP_CD),'O') <> 'O'" ).append("\n"); 
		query.append("                             THEN 'X'" ).append("\n"); 
		query.append("                        WHEN NVL(DECODE(SUBSTR(REGEXP_SUBSTR(@[ocn_str],'.{7}-WD-.-...-.{7}',1,4),1,5)||'-'||SUBSTR(REGEXP_SUBSTR(@[ocn_str],'.{7}-WD-.-...-.{7}',1,4),18,5)," ).append("\n"); 
		query.append("                                                     ORG_LOC_CD||'-'||N1ST_POD_CD,N1.VSL_SVC_TP_CD," ).append("\n"); 
		query.append("                                                     N2ND_POL_CD||'-'||N2ND_POD_CD,N2.VSL_SVC_TP_CD," ).append("\n"); 
		query.append("                                                     N3RD_POL_CD||'-'||N3RD_POD_CD,N3.VSL_SVC_TP_CD," ).append("\n"); 
		query.append("                                                     N4TH_POL_CD||'-'||DEST_LOC_CD,N4.VSL_SVC_TP_CD),'O') <> 'O'" ).append("\n"); 
		query.append("                             THEN 'X'" ).append("\n"); 
		query.append("                   ELSE 'Y'" ).append("\n"); 
		query.append("                END) OCN_SO_CHK" ).append("\n"); 
		query.append("                FROM PRD_OCN_ROUT A,MDM_VSL_SVC_LANE N1,MDM_VSL_SVC_LANE N2,MDM_VSL_SVC_LANE N3,MDM_VSL_SVC_LANE N4" ).append("\n"); 
		query.append("				WHERE A.ORG_LOC_CD IN (" ).append("\n"); 
		query.append("								  SELECT DISTINCT SUBSTR(T1.ROUT_DEST_NOD_CD, 1, 5) AS ROUT_DEST_LOC_CD" ).append("\n"); 
		query.append("									FROM PRD_INLND_ROUT_MST T1" ).append("\n"); 
		query.append("								   WHERE T1.ROUT_ORG_NOD_CD LIKE NVL(@[por_n], @[por]) || '%'" ).append("\n"); 
		query.append("									 AND T1.PCTL_IO_BND_CD IN ('O', 'B')" ).append("\n"); 
		query.append("									 AND NVL(T1.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("								  UNION" ).append("\n"); 
		query.append("								  SELECT PORT_CD" ).append("\n"); 
		query.append("									FROM PRD_HUB_LOC_MTCH J1" ).append("\n"); 
		query.append("								   WHERE J1.LOC_CD = @[por] " ).append("\n"); 
		query.append("									AND NOT EXISTS (SELECT DISTINCT SUBSTR(T1.ROUT_DEST_NOD_CD, 1, 5) AS ROUT_DEST_LOC_CD" ).append("\n"); 
		query.append("											FROM PRD_INLND_ROUT_MST T1" ).append("\n"); 
		query.append("										   WHERE T1.ROUT_ORG_NOD_CD LIKE NVL(@[por_n], @[por]) || '%'" ).append("\n"); 
		query.append("									     AND T1.ROUT_ORG_NOD_CD = J1.PORT_CD" ).append("\n"); 
		query.append("											 AND T1.PCTL_IO_BND_CD IN ('O', 'B')" ).append("\n"); 
		query.append("											 AND NVL(T1.DELT_FLG, 'N') = 'N')" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("                AND A.ORG_LOC_CD = NVL(@[pol], A.ORG_LOC_CD)				" ).append("\n"); 
		query.append("                AND A.DEST_LOC_CD IN (SELECT DISTINCT PORT_CD FROM PRD_HUB_LOC_MTCH WHERE LOC_CD = @[del] AND PORT_CD = NVL(@[pod],PORT_CD))" ).append("\n"); 
		query.append("                AND NVL(A.UPD_IND_CD,'S') IN ('C','U','S','T','A','V','G')" ).append("\n"); 
		query.append("                AND N1.VSL_SLAN_CD(+) = N1ST_LANE_CD" ).append("\n"); 
		query.append("                AND N2.VSL_SLAN_CD(+) = N2ND_LANE_CD" ).append("\n"); 
		query.append("                AND N3.VSL_SLAN_CD(+) = N3RD_LANE_CD" ).append("\n"); 
		query.append("                AND N4.VSL_SLAN_CD(+) = N4TH_LANE_CD" ).append("\n"); 
		query.append("                AND N1ST_POL_CD = NVL(@[pol1],N1ST_POL_CD)" ).append("\n"); 
		query.append("                AND N1ST_POD_CD = NVL(@[pod1],N1ST_POD_CD)" ).append("\n"); 
		query.append("                AND N1ST_LANE_CD IN ( NVL(@[lane1],N1ST_LANE_CD), (SELECT DECODE(VSL_SVC_TP_CD,'O','FDR',VSL_SLAN_CD) FROM MDM_VSL_SVC_LANE WHERE VSL_SLAN_CD = @[lane1]) )" ).append("\n"); 
		query.append("                AND NVL(N2ND_POL_CD,'X') = NVL(@[pol2],NVL(N2ND_POL_CD,'X'))" ).append("\n"); 
		query.append("                AND NVL(N2ND_POD_CD,'X') = NVL(@[pod2],NVL(N2ND_POD_CD,'X'))" ).append("\n"); 
		query.append("                AND NVL(N2ND_LANE_CD,'X') IN ( NVL(@[lane2],NVL(N2ND_LANE_CD,'X')), (SELECT DECODE(VSL_SVC_TP_CD,'O','FDR',VSL_SLAN_CD) FROM MDM_VSL_SVC_LANE WHERE VSL_SLAN_CD = @[lane2]) )" ).append("\n"); 
		query.append("                AND NVL(N3RD_POL_CD,'X') = NVL(@[pol3],NVL(N3RD_POL_CD,'X'))" ).append("\n"); 
		query.append("                AND NVL(N3RD_POD_CD,'X') = NVL(@[pod3],NVL(N3RD_POD_CD,'X'))" ).append("\n"); 
		query.append("                AND NVL(N3RD_LANE_CD,'X') IN ( NVL(@[lane3],NVL(N3RD_LANE_CD,'X')), (SELECT DECODE(VSL_SVC_TP_CD,'O','FDR',VSL_SLAN_CD) FROM MDM_VSL_SVC_LANE WHERE VSL_SLAN_CD = @[lane3]) )" ).append("\n"); 
		query.append("                AND NVL(N4TH_POL_CD,'X') = NVL(@[pol4],NVL(N4TH_POL_CD,'X'))" ).append("\n"); 
		query.append("                AND NVL(N4TH_POD_CD,'X') = NVL(@[pod4],NVL(N4TH_POD_CD,'X'))" ).append("\n"); 
		query.append("                AND NVL(N4TH_LANE_CD,'X') IN ( NVL(@[lane4],NVL(N4TH_LANE_CD,'X')), (SELECT DECODE(VSL_SVC_TP_CD,'O','FDR',VSL_SLAN_CD) FROM MDM_VSL_SVC_LANE WHERE VSL_SLAN_CD = @[lane4]) )" ).append("\n"); 
		query.append("				--REGEXP_SUBSTR(source, 표현식, 시작위치, 발생횟수, Matching Modifiers ) (상단 검사조건으로 올라감)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                AND (  (SELECT (CASE WHEN" ).append("\n"); 
		query.append("                               (SELECT VSL_SVC_TP_CD FROM MDM_VSL_SVC_LANE" ).append("\n"); 
		query.append("                                    WHERE VSL_SLAN_CD =V.SLAN_CD ) = 'O' THEN 'FDR'" ).append("\n"); 
		query.append("                                         ELSE V.SLAN_CD" ).append("\n"); 
		query.append("                               END) SLAN_CD" ).append("\n"); 
		query.append("                       FROM VSK_VSL_PORT_SKD  V,VSK_VSL_PORT_SKD  V2" ).append("\n"); 
		query.append("                       WHERE V.VSL_CD= substr(@[vvd],1,4)" ).append("\n"); 
		query.append("                        and V.SKD_VOY_NO= substr(@[vvd],5,4)" ).append("\n"); 
		query.append("                        and V.SKD_DIR_CD = substr(@[vvd],9,1)" ).append("\n"); 
		query.append("                        and NVL(V.SKD_CNG_STS_CD,'N') <> 'S'" ).append("\n"); 
		query.append("                        AND V2.VSL_CD= substr(@[vvd],1,4)" ).append("\n"); 
		query.append("                        and V2.SKD_VOY_NO= substr(@[vvd],5,4)" ).append("\n"); 
		query.append("                        and V2.SKD_DIR_CD = substr(@[vvd],9,1)" ).append("\n"); 
		query.append("                        and NVL(V2.SKD_CNG_STS_CD,'N') <> 'S'" ).append("\n"); 
		query.append("                        AND V2.CLPT_SEQ > V.CLPT_SEQ" ).append("\n"); 
		query.append("                        AND ROWNUM=1 )      IN ( N1ST_LANE_CD,N2ND_LANE_CD,N3RD_LANE_CD,N4TH_LANE_CD,'FDR')" ).append("\n"); 
		query.append("                    OR NVL(@[vvd],'X') = 'X'" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("                AND NOT EXISTS" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                   SELECT 'X' FROM PRD_MBGO_MGMT TT" ).append("\n"); 
		query.append("                   WHERE SUBSTR (A.ORG_LOC_CD, 1, 2) = TT.FM_CNT_CD" ).append("\n"); 
		query.append("                   AND A.TS_IND_CD = 'D'" ).append("\n"); 
		query.append("                   AND SUBSTR (A.DEST_LOC_CD, 1, 2) = TT.TO_CNT_CD" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("				UNION ALL" ).append("\n"); 
		query.append("                SELECT (SELECT TO_CHAR(COUNT(*)) FROM PRD_HUB_LOC_MTCH WHERE LOC_CD = @[del] AND PORT_CD = NVL(@[pod],PORT_CD)) HUB_COUNT," ).append("\n"); 
		query.append("                        '', '', 0, 0, '', '', '', '', '', '', '', '', '', '', '', 0, 0, 0, 0, '','','Y' FROM dual" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            ) B" ).append("\n"); 
		query.append("			--WHERE B.OCN_SO_CHK = 'Y'" ).append("\n"); 
		query.append("        ) C" ).append("\n"); 
		query.append("     ) T , PRD_INLND_ROUT_MST O, PRD_INLND_ROUT_MST I" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND NVL(O.PCTL_IO_BND_CD(+),'O') = 'O'" ).append("\n"); 
		query.append("    AND O.ROUT_ORG_NOD_CD(+)" ).append("\n"); 
		query.append("        LIKE CASE WHEN @[rcv_t] IN ('F', 'T') THEN 'X'" ).append("\n"); 
		query.append("                  WHEN @[por_n] IS NOT NULL THEN DECODE(@[por_n], T.POL1, 'X', @[por_n])" ).append("\n"); 
		query.append("                  WHEN @[rcv_t] = 'D' THEN OB_REP_ZN_CD" ).append("\n"); 
		query.append("                  WHEN @[rcv_t] = 'S' AND NVL(T.POL1_S, 'N') <> 'Y' THEN @[por] || '%'" ).append("\n"); 
		query.append("                  WHEN @[por] = @[pol] THEN DECODE(REPLACE(@[ob_str], '%', ''), NULL, 'X', @[por] || '%')" ).append("\n"); 
		query.append("                  ELSE @[por] || '%'" ).append("\n"); 
		query.append("            END" ).append("\n"); 
		query.append("    AND O.ROUT_DEST_NOD_CD(+)= DECODE(@[rcv_t], 'F', 'X', 'T', 'X', T.POL1)" ).append("\n"); 
		query.append("    AND NVL(O.DELT_FLG(+),'N') <> 'Y'" ).append("\n"); 
		query.append("    AND NVL(O.TRSP_MOD_CD(+),'X') = DECODE ( NVL(@[ob_trsp_mode],'AL'), 'AL', NVL(O.TRSP_MOD_CD(+),'X') , @[ob_trsp_mode]  )  " ).append("\n"); 
		query.append("    AND NVL(I.PCTL_IO_BND_CD(+),'I') = 'I'" ).append("\n"); 
		query.append("    AND I.ROUT_ORG_NOD_CD(+)= DECODE(@[del_t], 'F', 'X', 'T', 'X', T.POD_NODE)" ).append("\n"); 
		query.append("    AND I.ROUT_DEST_NOD_CD(+) " ).append("\n"); 
		query.append("        LIKE CASE WHEN @[del_t] IN ('F', 'T') THEN 'X'" ).append("\n"); 
		query.append("                  WHEN @[del_n] IS NOT NULL THEN DECODE(@[del_n], T.POD_NODE, 'X', @[del_n])" ).append("\n"); 
		query.append("                  WHEN @[del_t] = 'D' THEN IB_REP_ZN_CD" ).append("\n"); 
		query.append("                  WHEN @[del_t] = 'S' AND NVL(T.POD_NODE_S, 'N') <> 'Y' THEN @[del] || '%'" ).append("\n"); 
		query.append("                  WHEN NVL(@[pod], SUBSTR(T.POD_NODE, 1,5)) = @[del] THEN DECODE(REPLACE(@[ib_str], '%', ''), NULL, 'X', @[del] || '%')" ).append("\n"); 
		query.append("                  ELSE @[del] || '%'" ).append("\n"); 
		query.append("             END" ).append("\n"); 
		query.append("    AND NVL(I.DELT_FLG(+),'N') <> 'Y'" ).append("\n"); 
		query.append("    AND NVL(I.TRSP_MOD_CD(+),'X') = DECODE ( NVL(@[ib_trsp_mode],'AL'), 'AL', NVL(I.TRSP_MOD_CD(+),'X') , @[ib_trsp_mode]  )" ).append("\n"); 
		query.append("	ORDER BY  DECODE(CHECK_ROUT,'Y',1, 2) ASC, DECODE(T.OCN_FLG,  'G',1, 'S', 2, 'T', 3, 'A', 4, 'V', 5, 'N', 6, 'D', 7)  ASC" ).append("\n"); 
		query.append("	     ,INSTR(NVL(PRD_GET_INLND_ROUT_STR_FNC(O.ROUT_ORG_NOD_CD,O.ROUT_DEST_NOD_CD,O.ROUT_SEQ),'X'),NVL(REGEXP_REPLACE(REGEXP_REPLACE(@[ob_str],'-...-','-'),'%',''),'X')) DESC" ).append("\n"); 
		query.append("         ,INSTR(NVL(PRD_GET_INLND_ROUT_STR_FNC(I.ROUT_ORG_NOD_CD,I.ROUT_DEST_NOD_CD,I.ROUT_SEQ),'X'),NVL(REGEXP_REPLACE(REGEXP_REPLACE(@[ib_str],'-...-','-'),'%',''),'X')) DESC" ).append("\n"); 
		query.append("         , 1 DESC" ).append("\n"); 
		query.append("         , 2 DESC" ).append("\n"); 
		query.append("         , 3 ASC" ).append("\n"); 
		query.append("		 , 4 ASC " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("WHERE  ROWNUM =1" ).append("\n"); 

	}
}