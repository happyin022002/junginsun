/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpecialCargoQuotationManageDBDAOremoveAwkCgoShuttleTrfHdrDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.10
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.04.10 이혜민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.specialcargoquotationmanage.awkwardcargomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hyemin Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoQuotationManageDBDAOremoveAwkCgoShuttleTrfHdrDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * removeAwkCgoShuttleTrfHdr
	  * </pre>
	  */
	public SpecialCargoQuotationManageDBDAOremoveAwkCgoShuttleTrfHdrDSQL(){
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
		params.put("io_ga_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trsp_crr_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esd.trs.specialcargoquotationmanage.awkwardcargomanage.integration").append("\n"); 
		query.append("FileName : SpecialCargoQuotationManageDBDAOremoveAwkCgoShuttleTrfHdrDSQL").append("\n"); 
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
		query.append("DELETE FROM TRS_AWK_CGO_TRF_HDR D" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND FM_YD_CD = @[fm_loc_cd]||@[fm_nod_yd_no]" ).append("\n"); 
		query.append("AND TO_YD_CD = @[to_loc_cd]||@[to_nod_yd_no]" ).append("\n"); 
		query.append("AND COND_NO = @[cond_no]" ).append("\n"); 
		query.append("AND IO_GA_CD = @[io_ga_cd]" ).append("\n"); 
		query.append("AND TRSP_CRR_MOD_CD = @[trsp_crr_mod_cd]" ).append("\n"); 
		query.append("AND NOT EXISTS(" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM TRS_AWK_CGO_TRF_TP_SZ T, PRI_SCQ_AWK_ROUT_DTL PD" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND T.FM_YD_CD = D.FM_YD_CD" ).append("\n"); 
		query.append("AND T.TO_YD_CD = D.TO_YD_CD" ).append("\n"); 
		query.append("AND T.COND_NO = D.COND_NO" ).append("\n"); 
		query.append("AND T.IO_GA_CD = D.IO_GA_CD" ).append("\n"); 
		query.append("AND T.TRSP_CRR_MOD_CD = D.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("AND T.TRSP_AWK_TRF_VER_NO = D.TRSP_AWK_TRF_VER_NO" ).append("\n"); 
		query.append("AND T.SPCL_CGO_REF_SEQ = PD.SPCL_CGO_REF_SEQ" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM TRS_AWK_CGO_TRF_TP_SZ T, PRI_SCQ_AWK_ROUT_DTL_TMP PM" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND T.FM_YD_CD = D.FM_YD_CD" ).append("\n"); 
		query.append("AND T.TO_YD_CD = D.TO_YD_CD" ).append("\n"); 
		query.append("AND T.COND_NO = D.COND_NO" ).append("\n"); 
		query.append("AND T.IO_GA_CD = D.IO_GA_CD" ).append("\n"); 
		query.append("AND T.TRSP_CRR_MOD_CD = D.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("AND T.TRSP_AWK_TRF_VER_NO = D.TRSP_AWK_TRF_VER_NO" ).append("\n"); 
		query.append("AND T.SPCL_CGO_REF_SEQ = PM.SPCL_CGO_REF_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}