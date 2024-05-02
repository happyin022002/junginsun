/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : IsraelManifestListDownloadDBDAOsearchRcvHisRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.12
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2016.02.12 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.israel.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Minjung Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IsraelManifestListDownloadDBDAOsearchRcvHisRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchRcvHis
	  * </pre>
	  */
	public IsraelManifestListDownloadDBDAOsearchRcvHisRSQL(){
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
		params.put("s_vps_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_vps_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.israel.integration").append("\n"); 
		query.append("FileName : IsraelManifestListDownloadDBDAOsearchRcvHisRSQL").append("\n"); 
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
		query.append("SELECT RCV.ACK_KND_ID" ).append("\n"); 
		query.append("     , DECODE(NVL(RCV.EUR_ACK_RCV_STS_CD, ''), 'A', 'Accepted', 'R', 'Rejected') AS EUR_ACK_RCV_STS_CD" ).append("\n"); 
		query.append("     , RCV.ACK_DT" ).append("\n"); 
		query.append("     , SND.BL_NO" ).append("\n"); 
		query.append("     , SND.VSL_CD||SND.SKD_VOY_NO||SND.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("     , RCV.EUR_CSTMS_RJCT_CD" ).append("\n"); 
		query.append("     , RCV.RJCT_RSN_RMK" ).append("\n"); 
		query.append("     , RCV.RJCT_DT" ).append("\n"); 
		query.append("     , ERR.CSTMS_ERR_ID" ).append("\n"); 
		query.append("     , ERR.CSTMS_ERR_MSG" ).append("\n"); 
		query.append("     , VVD.POL_CD" ).append("\n"); 
		query.append("     , VVD.POD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_EUR_IB_SND     SND" ).append("\n"); 
		query.append("     , BKG_CSTMS_EUR_IB_RCV     RCV" ).append("\n"); 
		query.append("     , BKG_CSTMS_EUR_IB_RCV_ERR ERR" ).append("\n"); 
		query.append("     , BKG_VVD                  VVD" ).append("\n"); 
		query.append("     , BKG_BOOKING              BKG" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND SND.CNT_CD = RCV.CNT_CD(+)" ).append("\n"); 
		query.append("   AND SND.MSG_SND_NO = RCV.MSG_RCV_NO(+)" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   AND RCV.CNT_CD = ERR.CNT_CD(+)" ).append("\n"); 
		query.append("   AND RCV.EDI_RCV_DT = ERR.EDI_RCV_DT(+)" ).append("\n"); 
		query.append("   AND RCV.EDI_RCV_SEQ = ERR.EDI_RCV_SEQ(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND VVD.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("   AND VVD.VSL_CD = SND.VSL_CD" ).append("\n"); 
		query.append("   AND VVD.SKD_VOY_NO = SND.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND VVD.SKD_DIR_CD = SND.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND SND.MSG_SND_NO LIKE VVD.BKG_NO||'%'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_vps_eta_dt}!= '' && ${cond_gubun}== '1')     	        " ).append("\n"); 
		query.append("   AND RCV.ACK_DT >= TO_DATE(REPLACE(REPLACE(@[s_vps_eta_dt], '-', ''), '/', ''), 'YYYYMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${e_vps_eta_dt}!= '' && ${cond_gubun}== '1')		  " ).append("\n"); 
		query.append("   AND RCV.ACK_DT <= TO_DATE(REPLACE(REPLACE(@[e_vps_eta_dt], '-', ''), '/', ''), 'YYYYMMDD') + 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("#if (${bl_no} != '') " ).append("\n"); 
		query.append("   AND BKG.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vvd} != '') " ).append("\n"); 
		query.append("   AND VVD.VSL_CD = SUBSTR(@[vvd], 1,4)" ).append("\n"); 
		query.append("   AND VVD.SKD_VOY_NO = SUBSTR(@[vvd], 5,4)" ).append("\n"); 
		query.append("   AND VVD.SKD_DIR_CD = SUBSTR(@[vvd], 9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_cd} != '') " ).append("\n"); 
		query.append("   AND VVD.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pod_cd} != '') " ).append("\n"); 
		query.append("   AND VVD.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY RCV.ACK_DT, SND.BL_NO, VVD.POL_CD, VVD.POD_CD" ).append("\n"); 

	}
}