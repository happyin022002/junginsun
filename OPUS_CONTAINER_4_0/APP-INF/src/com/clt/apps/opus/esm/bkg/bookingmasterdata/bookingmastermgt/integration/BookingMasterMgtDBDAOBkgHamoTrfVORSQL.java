/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BookingMasterMgtDBDAOBkgHamoTrfVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOBkgHamoTrfVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * HT Code 조회 화면
	  * </pre>
	  */
	public BookingMasterMgtDBDAOBkgHamoTrfVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hamo_cate_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hamo_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fda_decl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hamo_cd_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hamo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOBkgHamoTrfVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	HAMO_TP_CD" ).append("\n"); 
		query.append(",	HAMO_TRF_CD" ).append("\n"); 
		query.append(",	HAMO_CD_DESC" ).append("\n"); 
		query.append(",	HAMO_CATE_CTNT" ).append("\n"); 
		query.append(",	FDA_DECL_FLG" ).append("\n"); 
		query.append(",	DELT_FLG" ).append("\n"); 
		query.append(",	A.CRE_USR_ID --수정" ).append("\n"); 
		query.append(",	A.CRE_DT  --수정" ).append("\n"); 
		query.append(",	A.UPD_USR_ID --수정" ).append("\n"); 
		query.append(",	OFC_CD" ).append("\n"); 
		query.append(",	TO_CHAR(A.UPD_DT,'YYYY-MM-DD') UPD_DT-- 수정 (시분초안나오게)" ).append("\n"); 
		query.append(",	TO_CHAR(A.EXP_DT,'YYYY-MM-DD') EXP_DT" ).append("\n"); 
		query.append(",	TO_CHAR(A.EFF_DT,'YYYY-MM-DD') EFF_DT" ).append("\n"); 
		query.append(",	HAMO_TRF_CD_SEQ" ).append("\n"); 
		query.append("FROM BKG_HAMO_TRF A , COM_USER B" ).append("\n"); 
		query.append("WHERE	1=1" ).append("\n"); 
		query.append("AND A.UPD_USR_ID = B.USR_ID(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--AND	HAMO_TP_CD = 'T' " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${hamo_tp_cd} != '') " ).append("\n"); 
		query.append("AND	HAMO_TP_CD = @[hamo_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${hamo_trf_cd}!='')" ).append("\n"); 
		query.append("AND	HAMO_TRF_CD LIKE  @[hamo_trf_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${hamo_cd_desc}!='')" ).append("\n"); 
		query.append("AND	UPPER(HAMO_CD_DESC) LIKE '%' ||  UPPER(@[hamo_cd_desc]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${hamo_cate_ctnt} != '') " ).append("\n"); 
		query.append("AND	UPPER(HAMO_CATE_CTNT) LIKE '%' ||  UPPER(@[hamo_cate_ctnt]) || '%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${fda_decl_flg} != '') " ).append("\n"); 
		query.append("AND	FDA_DECL_FLG = @[fda_decl_flg] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("#if (${delt_flg} == '') " ).append("\n"); 
		query.append("AND	nvl(delt_flg,'N') = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${exp_dt} != '') " ).append("\n"); 
		query.append("AND TO_DATE(@[exp_dt],'YYYY-MM-DD') BETWEEN EFF_DT AND NVL(EXP_DT,TO_DATE('9999-12-31','YYYY-MM-DD'))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY EFF_DT, HAMO_TRF_CD_SEQ" ).append("\n"); 

	}
}