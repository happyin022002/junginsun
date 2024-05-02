/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BookingMasterMgtDBDAOBkgHamoTrfCntVORSQLRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.01
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2011.08.01 조원주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOBkgHamoTrfCntVORSQLRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingMasterMgtDBDAOBkgHamoTrfCntVORSQL
	  * </pre>
	  */
	public BookingMasterMgtDBDAOBkgHamoTrfCntVORSQLRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOBkgHamoTrfCntVORSQLRSQL").append("\n"); 
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
		query.append("COUNT(*)" ).append("\n"); 
		query.append(" FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
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
		query.append(",	ROW_NUMBER() OVER (ORDER BY HAMO_TRF_CD ASC) NO" ).append("\n"); 
		query.append("" ).append("\n"); 
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
		query.append("AND	UPPER(HAMO_CD_DESC) LIKE '%' ||  @[hamo_cd_desc] || '%'" ).append("\n"); 
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
		query.append(")" ).append("\n"); 

	}
}