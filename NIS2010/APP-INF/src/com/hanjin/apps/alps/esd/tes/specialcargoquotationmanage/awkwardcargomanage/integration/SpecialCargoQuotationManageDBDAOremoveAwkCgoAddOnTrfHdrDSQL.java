/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpecialCargoQuotationManageDBDAOremoveAwkCgoAddOnTrfHdrDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.15
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.04.15 이혜민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hyemin Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoQuotationManageDBDAOremoveAwkCgoAddOnTrfHdrDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * removeAwkCgoAddOnTrfHdr
	  * </pre>
	  */
	public SpecialCargoQuotationManageDBDAOremoveAwkCgoAddOnTrfHdrDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_nod_yd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_nod_yd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cond_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.integration").append("\n"); 
		query.append("FileName : SpecialCargoQuotationManageDBDAOremoveAwkCgoAddOnTrfHdrDSQL").append("\n"); 
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
		query.append("DELETE FROM TES_AWK_CGO_ADON_HDR D" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND FM_LOC_CD = @[fm_loc_cd]" ).append("\n"); 
		query.append("AND FM_NOD_YD_NO = DECODE(@[fm_nod_yd_no],'',' ',@[fm_nod_yd_no])" ).append("\n"); 
		query.append("AND TO_LOC_CD = @[to_loc_cd]" ).append("\n"); 
		query.append("AND TO_NOD_YD_NO = DECODE(@[to_nod_yd_no],'',' ',@[to_nod_yd_no])" ).append("\n"); 
		query.append("AND COND_NO = @[cond_no]" ).append("\n"); 
		query.append("AND NOT EXISTS (" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM TES_AWK_CGO_ADON_TP_SZ T, PRI_SCQ_AWK_ROUT_DTL PD" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND T.FM_LOC_CD = D.FM_LOC_CD" ).append("\n"); 
		query.append("AND T.FM_NOD_YD_NO = D.FM_NOD_YD_NO" ).append("\n"); 
		query.append("AND T.TO_LOC_CD = D.TO_LOC_CD" ).append("\n"); 
		query.append("AND T.TO_NOD_YD_NO = D.TO_NOD_YD_NO" ).append("\n"); 
		query.append("AND T.COND_NO = D.COND_NO" ).append("\n"); 
		query.append("AND T.TML_AWK_ADON_VER_NO = D.TML_AWK_ADON_VER_NO" ).append("\n"); 
		query.append("AND T.SPCL_CGO_REF_SEQ = PD.SPCL_CGO_REF_SEQ" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM TES_AWK_CGO_ADON_TP_SZ T, PRI_SCQ_AWK_ROUT_DTL_TMP PM" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND T.FM_LOC_CD = D.FM_LOC_CD" ).append("\n"); 
		query.append("AND T.FM_NOD_YD_NO = D.FM_NOD_YD_NO" ).append("\n"); 
		query.append("AND T.TO_LOC_CD = D.TO_LOC_CD" ).append("\n"); 
		query.append("AND T.TO_NOD_YD_NO = D.TO_NOD_YD_NO" ).append("\n"); 
		query.append("AND T.COND_NO = D.COND_NO" ).append("\n"); 
		query.append("AND T.TML_AWK_ADON_VER_NO = D.TML_AWK_ADON_VER_NO" ).append("\n"); 
		query.append("AND T.SPCL_CGO_REF_SEQ = PM.SPCL_CGO_REF_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}