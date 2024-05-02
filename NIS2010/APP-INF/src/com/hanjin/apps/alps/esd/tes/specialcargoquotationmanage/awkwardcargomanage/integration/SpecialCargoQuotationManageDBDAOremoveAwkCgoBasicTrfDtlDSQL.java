/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpecialCargoQuotationManageDBDAOremoveAwkCgoBasicTrfDtlDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.10
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.04.10 이혜민
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

public class SpecialCargoQuotationManageDBDAOremoveAwkCgoBasicTrfDtlDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * removeAwkCgoBasicTrfDtl
	  * </pre>
	  */
	public SpecialCargoQuotationManageDBDAOremoveAwkCgoBasicTrfDtlDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_awk_ts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tml_awk_cgo_trf_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.integration").append("\n"); 
		query.append("FileName : SpecialCargoQuotationManageDBDAOremoveAwkCgoBasicTrfDtlDSQL").append("\n"); 
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
		query.append("DELETE FROM TES_AWK_CGO_TRF_DTL D" ).append("\n"); 
		query.append("WHERE YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("AND TML_AWK_CGO_TRF_TP_CD = @[tml_awk_cgo_trf_tp_cd]" ).append("\n"); 
		query.append("AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND IO_GA_CD = @[io_ga_cd]" ).append("\n"); 
		query.append("AND TML_AWK_TS_CD = @[tml_awk_ts_cd]" ).append("\n"); 
		query.append("AND COND_NO = @[cond_no]" ).append("\n"); 
		query.append("AND NOT EXISTS (" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM TES_AWK_CGO_TRF_TP_SZ T, PRI_SCQ_AWK_YD_DTL PD" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND T.YD_CD = D.YD_CD" ).append("\n"); 
		query.append("AND T.TML_AWK_CGO_TRF_TP_CD = D.TML_AWK_CGO_TRF_TP_CD" ).append("\n"); 
		query.append("AND T.IO_BND_CD = D.IO_BND_CD" ).append("\n"); 
		query.append("AND T.IO_GA_CD = D.IO_GA_CD" ).append("\n"); 
		query.append("AND T.TML_AWK_TS_CD = D.TML_AWK_TS_CD" ).append("\n"); 
		query.append("AND T.COND_NO = D.COND_NO" ).append("\n"); 
		query.append("AND T.TML_AWK_TRF_VER_NO = D.TML_AWK_TRF_VER_NO" ).append("\n"); 
		query.append("AND T.SPCL_CGO_REF_SEQ = PD.SPCL_CGO_REF_SEQ" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM TES_AWK_CGO_TRF_TP_SZ T, PRI_SCQ_AWK_YD_DTL_TMP PM" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND T.YD_CD = D.YD_CD" ).append("\n"); 
		query.append("AND T.TML_AWK_CGO_TRF_TP_CD = D.TML_AWK_CGO_TRF_TP_CD" ).append("\n"); 
		query.append("AND T.IO_BND_CD = D.IO_BND_CD" ).append("\n"); 
		query.append("AND T.IO_GA_CD = D.IO_GA_CD" ).append("\n"); 
		query.append("AND T.TML_AWK_TS_CD = D.TML_AWK_TS_CD" ).append("\n"); 
		query.append("AND T.COND_NO = D.COND_NO" ).append("\n"); 
		query.append("AND T.TML_AWK_TRF_VER_NO = D.TML_AWK_TRF_VER_NO" ).append("\n"); 
		query.append("AND T.SPCL_CGO_REF_SEQ = PM.SPCL_CGO_REF_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}