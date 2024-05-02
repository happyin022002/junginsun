/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingUtilDBDAOSearchVvdBdrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.06
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2009.11.06 김태경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOSearchVvdBdrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * vvd, pol로 BDR 여부 조회(vvd, pol로 bkg_bdr_log를 확인하여 bdr이 걸렸으면(trnk_bdr_flg or bdr_bdr_flg) 중지한다)
	  * </pre>
	  */
	public BookingUtilDBDAOSearchVvdBdrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchVvdBdrRSQL").append("\n"); 
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
		query.append("VSL_CD" ).append("\n"); 
		query.append(",	SKD_VOY_NO" ).append("\n"); 
		query.append(",	SKD_DIR_CD" ).append("\n"); 
		query.append(",	POL_CD" ).append("\n"); 
		query.append(",	POD_CD" ).append("\n"); 
		query.append(",	POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append(",	SLAN_CD" ).append("\n"); 
		query.append(",	SLAN_TP_CD" ).append("\n"); 
		query.append(",	TRNK_BDR_FLG" ).append("\n"); 
		query.append(",	TRNK_ESTM_BDR_DT" ).append("\n"); 
		query.append(",	TRNK_AUTO_BDR_FLG" ).append("\n"); 
		query.append(",	TRNK_AUTO_BDR_DT" ).append("\n"); 
		query.append(",	TRNK_MNL_BDR_FLG" ).append("\n"); 
		query.append(",	TRNK_MNL_BDR_DT" ).append("\n"); 
		query.append(",	TRNK_BDR_CRE_USR_ID" ).append("\n"); 
		query.append(",	FDR_BDR_FLG" ).append("\n"); 
		query.append(",	FDR_ESTM_BDR_DT" ).append("\n"); 
		query.append(",	FDR_AUTO_BDR_FLG" ).append("\n"); 
		query.append(",	FDR_AUTO_BDR_DT" ).append("\n"); 
		query.append(",	FDR_MNL_BDR_FLG" ).append("\n"); 
		query.append(",	FDR_MNL_BDR_DT" ).append("\n"); 
		query.append(",	FDR_BDR_CRE_USR_ID" ).append("\n"); 
		query.append(",	FDR_BDR_UPD_DT" ).append("\n"); 
		query.append(",	BDR_VSL_CHK_FLG" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	NVL(TRNK_AUTO_BDR_FLG,FDR_AUTO_BDR_FLG) BDR_FLG" ).append("\n"); 
		query.append("FROM BKG_VVD_BDR_LOG" ).append("\n"); 
		query.append("WHERE	VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND	SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND	POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("AND	POD_CD = NVL(@[pod_cd], POD_CD)" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}