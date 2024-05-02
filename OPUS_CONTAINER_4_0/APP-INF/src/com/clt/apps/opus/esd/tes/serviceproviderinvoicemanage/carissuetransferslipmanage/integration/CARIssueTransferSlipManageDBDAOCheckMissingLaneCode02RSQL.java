/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CARIssueTransferSlipManageDBDAOCheckMissingLaneCode02RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.15
*@LastModifier : 박재흥
*@LastVersion : 1.0
* 2009.11.15 박재흥
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.clt.framework.core.layer.integration.DAO;
import com.clt.framework.support.db.ISQLTemplate;

/**
*
* @author park chae heung
* @see DAO 참조
* @since J2EE 1.6
*/

public class CARIssueTransferSlipManageDBDAOCheckMissingLaneCode02RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CheckMissingLaneCode02
	  * </pre>
	  */
	public CARIssueTransferSlipManageDBDAOCheckMissingLaneCode02RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});
		
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration ").append("\n"); 
		query.append("FileName : CARIssueTransferSlipManageDBDAOCheckMissingLaneCode02RSQL").append("\n"); 
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
		query.append("CASE" ).append("\n"); 
		query.append("WHEN SIGN(NVL((SELECT SUM(D.RVIS_VOL_QTY) FROM TES_TML_SO_DTL D" ).append("\n"); 
		query.append("WHERE D.TML_SO_OFC_CTY_CD = X.TML_SO_OFC_CTY_CD AND D.TML_SO_SEQ = X.TML_SO_SEQ AND D.CALC_TP_CD = 'A'),0)" ).append("\n"); 
		query.append("- NVL(SUM(RVIS_VOL_QTY),0)) = 0" ).append("\n"); 
		query.append("THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END LANE_CD_MATCH_CHK" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("D.TML_SO_OFC_CTY_CD, D.TML_SO_SEQ," ).append("\n"); 
		query.append("NVL(D.RVIS_VOL_QTY,0) RVIS_VOL_QTY" ).append("\n"); 
		query.append("FROM   (SELECT L.*" ).append("\n"); 
		query.append("FROM   TES_TML_SO_HDR H, TES_TML_SO_CNTR_LIST L" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    H.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("AND    H.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("AND    H.TML_INV_TP_CD = 'TM'" ).append("\n"); 
		query.append("AND    NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND    H.TML_SO_OFC_CTY_CD = L.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND    H.TML_SO_SEQ = L.TML_SO_SEQ" ).append("\n"); 
		query.append("AND    L.VRFY_RSLT_IND_CD      = 'CO') L," ).append("\n"); 
		query.append("(SELECT D.* FROM TES_TML_SO_DTL D WHERE D.CALC_TP_CD = 'A') D" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND    L.TML_SO_OFC_CTY_CD = D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND    L.TML_SO_SEQ = D.TML_SO_SEQ" ).append("\n"); 
		query.append("AND    L.VSL_CD     = D.VSL_CD" ).append("\n"); 
		query.append("AND    L.SKD_VOY_NO = D.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    L.SKD_DIR_CD = D.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    L.IO_BND_CD  = D.IO_BND_CD" ).append("\n"); 
		query.append("AND    DECODE(L.BB_CGO_FLG,'Y','BB',DECODE(L.LOCL_TS_IND_CD,'T',DECODE(L.CNTR_STY_CD,'F','TS','TM'),DECODE(L.CNTR_STY_CD,'F','FL','MT'))) = SUBSTR(D.LGS_COST_CD,5,2)" ).append("\n"); 
		query.append("AND    NVL(L.CNTR_TPSZ_CD,'X') = NVL(D.CNTR_TPSZ_CD,'X')" ).append("\n"); 
		query.append("AND    NVL(L.IO_BND_CD,'X')     = NVL(D.IO_BND_CD,'X')" ).append("\n"); 
		query.append("AND    NVL(L.DCGO_CLSS_CD,'X') = NVL(D.DCGO_IND_CD,'X')" ).append("\n"); 
		query.append("AND    NVL(L.IOC_CD,'X')         = NVL(D.IOC_CD,'X')" ).append("\n"); 
		query.append("AND    NVL(L.LANE_CD,'X')         = NVL(D.LANE_CD,'X')" ).append("\n"); 
		query.append("AND    DECODE(D.TML_TRNS_MOD_CD,'','S','S','S',NVL(L.TML_TRNS_MOD_CD,'S')) = NVL(D.TML_TRNS_MOD_CD,'S')" ).append("\n"); 
		query.append("GROUP BY D.TML_SO_OFC_CTY_CD, D.TML_SO_SEQ, D.VSL_CD, D.SKD_VOY_NO, D.SKD_DIR_CD, D.IO_BND_CD," ).append("\n"); 
		query.append("D.LGS_COST_CD, D.CNTR_TPSZ_CD, D.IOC_CD, D.TML_TRNS_MOD_CD, D.DCGO_IND_CD, --D.RC_FLG," ).append("\n"); 
		query.append("D.FM_TR_VOL_VAL, D.TO_TR_VOL_VAL, D.LANE_CD, D.RVIS_VOL_QTY" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append("WHERE X.TML_SO_OFC_CTY_CD IS NOT NULL AND X.TML_SO_SEQ IS NOT NULL" ).append("\n"); 
		query.append("GROUP BY X.TML_SO_OFC_CTY_CD, X.TML_SO_SEQ" ).append("\n"); 

	}
}