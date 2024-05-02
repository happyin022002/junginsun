/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpecialCargoQuotationManageDBDAOmodifyAwkCgoBasicTrfTpSzUSQL.java
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

public class SpecialCargoQuotationManageDBDAOmodifyAwkCgoBasicTrfTpSzUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyAwkCgoBasicTrfTpSz
	  * </pre>
	  */
	public SpecialCargoQuotationManageDBDAOmodifyAwkCgoBasicTrfTpSzUSQL(){
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
		params.put("locl_curr_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_awk_cgo_trf_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tml_awk_uc_calc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usd_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usd_xch_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.integration").append("\n"); 
		query.append("FileName : SpecialCargoQuotationManageDBDAOmodifyAwkCgoBasicTrfTpSzUSQL").append("\n"); 
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
		query.append("MERGE INTO TES_AWK_CGO_TRF_TP_SZ V" ).append("\n"); 
		query.append("USING  DUAL" ).append("\n"); 
		query.append("ON (    V.YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("AND V.TML_AWK_CGO_TRF_TP_CD = @[tml_awk_cgo_trf_tp_cd]" ).append("\n"); 
		query.append("AND V.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND V.IO_GA_CD = @[io_ga_cd]" ).append("\n"); 
		query.append("AND V.TML_AWK_TS_CD = @[tml_awk_ts_cd]" ).append("\n"); 
		query.append("AND V.COND_NO = @[cond_no]" ).append("\n"); 
		query.append("AND V.TML_AWK_TRF_VER_NO = (SELECT NVL(MAX(TML_AWK_TRF_VER_NO),0)" ).append("\n"); 
		query.append("FROM TES_AWK_CGO_TRF_DTL" ).append("\n"); 
		query.append("WHERE YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("AND TML_AWK_CGO_TRF_TP_CD = @[tml_awk_cgo_trf_tp_cd]" ).append("\n"); 
		query.append("AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND IO_GA_CD = @[io_ga_cd]" ).append("\n"); 
		query.append("AND TML_AWK_TS_CD = @[tml_awk_ts_cd]" ).append("\n"); 
		query.append("AND COND_NO = @[cond_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND V.TML_AWK_UC_CALC_TP_CD = @[tml_awk_uc_calc_tp_cd]" ).append("\n"); 
		query.append("AND V.CNTR_SZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET" ).append("\n"); 
		query.append("LOCL_CURR_CD = @[locl_curr_cd]," ).append("\n"); 
		query.append("LOCL_CURR_AMT = @[locl_curr_amt]," ).append("\n"); 
		query.append("USD_AMT = @[usd_amt]," ).append("\n"); 
		query.append("USD_XCH_DT = @[usd_xch_dt]," ).append("\n"); 
		query.append("UPD_USR_ID =  @[upd_usr_id]," ).append("\n"); 
		query.append("UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (" ).append("\n"); 
		query.append("YD_CD," ).append("\n"); 
		query.append("TML_AWK_CGO_TRF_TP_CD," ).append("\n"); 
		query.append("IO_BND_CD," ).append("\n"); 
		query.append("IO_GA_CD," ).append("\n"); 
		query.append("TML_AWK_TS_CD," ).append("\n"); 
		query.append("COND_NO," ).append("\n"); 
		query.append("TML_AWK_TRF_VER_NO," ).append("\n"); 
		query.append("TML_AWK_UC_CALC_TP_CD," ).append("\n"); 
		query.append("CNTR_SZ_CD," ).append("\n"); 
		query.append("LOCL_CURR_CD," ).append("\n"); 
		query.append("LOCL_CURR_AMT," ).append("\n"); 
		query.append("USD_AMT," ).append("\n"); 
		query.append("USD_XCH_DT," ).append("\n"); 
		query.append("SPCL_CGO_REF_SEQ," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("@[yd_cd]," ).append("\n"); 
		query.append("@[tml_awk_cgo_trf_tp_cd]," ).append("\n"); 
		query.append("@[io_bnd_cd]," ).append("\n"); 
		query.append("@[io_ga_cd]," ).append("\n"); 
		query.append("@[tml_awk_ts_cd]," ).append("\n"); 
		query.append("@[cond_no]," ).append("\n"); 
		query.append("(SELECT NVL(MAX(TML_AWK_TRF_VER_NO),0)" ).append("\n"); 
		query.append("FROM TES_AWK_CGO_TRF_DTL" ).append("\n"); 
		query.append("WHERE YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("AND TML_AWK_CGO_TRF_TP_CD = @[tml_awk_cgo_trf_tp_cd]" ).append("\n"); 
		query.append("AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND IO_GA_CD = @[io_ga_cd]" ).append("\n"); 
		query.append("AND TML_AWK_TS_CD = @[tml_awk_ts_cd]" ).append("\n"); 
		query.append("AND COND_NO = @[cond_no]" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("@[tml_awk_uc_calc_tp_cd]," ).append("\n"); 
		query.append("@[cntr_tpsz_cd]," ).append("\n"); 
		query.append("@[locl_curr_cd]," ).append("\n"); 
		query.append("@[locl_curr_amt]," ).append("\n"); 
		query.append("@[usd_amt]," ).append("\n"); 
		query.append("@[usd_xch_dt]," ).append("\n"); 
		query.append("DECODE(@[tml_awk_uc_calc_tp_cd],'S',TES_SPCL_CGO_REF_SEQ.nextval,0)," ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("Y.OFC_CD" ).append("\n"); 
		query.append("FROM MDM_YARD Y" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND Y.YD_CD LIKE @[yd_cd])," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE)" ).append("\n"); 

	}
}