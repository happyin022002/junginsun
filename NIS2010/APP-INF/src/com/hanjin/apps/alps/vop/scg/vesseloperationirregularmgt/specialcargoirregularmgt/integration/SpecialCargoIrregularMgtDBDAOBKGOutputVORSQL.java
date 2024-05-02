/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialCargoIrregularMgtDBDAOBKGOutputVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.07.28 김현욱
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Hyun Uk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoIrregularMgtDBDAOBKGOutputVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Booking 정보 조회
	  * </pre>
	  */
	public SpecialCargoIrregularMgtDBDAOBKGOutputVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.integration").append("\n"); 
		query.append("FileName : SpecialCargoIrregularMgtDBDAOBKGOutputVORSQL").append("\n"); 
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
		query.append("BK.SPLIT_FLG" ).append("\n"); 
		query.append(",	BK.BKG_NO" ).append("\n"); 
		query.append(",	BK.BL_NO" ).append("\n"); 
		query.append(",	BK.POR_CD" ).append("\n"); 
		query.append(",	BK.POL_CD" ).append("\n"); 
		query.append(",	BK.POD_CD" ).append("\n"); 
		query.append(",	BK.DEL_CD" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT MC.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER MC" ).append("\n"); 
		query.append("WHERE MC.CUST_CNT_CD = SH.CUST_CNT_CD" ).append("\n"); 
		query.append("AND MC.CUST_SEQ    = SH.CUST_SEQ" ).append("\n"); 
		query.append(") S_CUST_NM" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT MC.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER MC" ).append("\n"); 
		query.append("WHERE MC.CUST_CNT_CD = FF.CUST_CNT_CD" ).append("\n"); 
		query.append("AND MC.CUST_SEQ    = FF.CUST_SEQ" ).append("\n"); 
		query.append(") F_CUST_NM" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT MC.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER MC" ).append("\n"); 
		query.append("WHERE MC.CUST_CNT_CD = CN.CUST_CNT_CD" ).append("\n"); 
		query.append("AND MC.CUST_SEQ    = CN.CUST_SEQ" ).append("\n"); 
		query.append(") C_CUST_NM" ).append("\n"); 
		query.append(",	BK.DCGO_FLG" ).append("\n"); 
		query.append(",	BK.RC_FLG" ).append("\n"); 
		query.append(",	BK.AWK_CGO_FLG" ).append("\n"); 
		query.append(",	BK.BB_CGO_FLG" ).append("\n"); 
		query.append(",   BK.BKG_STS_CD" ).append("\n"); 
		query.append("FROM BKG_BOOKING  BK" ).append("\n"); 
		query.append(", BKG_VVD BV" ).append("\n"); 
		query.append(", BKG_CUSTOMER SH" ).append("\n"); 
		query.append(", BKG_CUSTOMER FF" ).append("\n"); 
		query.append(", BKG_CUSTOMER CN" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("BV.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND BV.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND BV.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND BV.BKG_NO     = BK.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("BK.BKG_NO         = @[bkg_no]" ).append("\n"); 
		query.append("OR BK.BL_NO          = @[bl_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND BK.BKG_NO         = SH.BKG_NO" ).append("\n"); 
		query.append("AND SH.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("AND BK.BKG_NO         = FF.BKG_NO" ).append("\n"); 
		query.append("AND FF.BKG_CUST_TP_CD = 'F'" ).append("\n"); 
		query.append("AND BK.BKG_NO         = CN.BKG_NO" ).append("\n"); 
		query.append("AND CN.BKG_CUST_TP_CD = 'C'" ).append("\n"); 

	}
}