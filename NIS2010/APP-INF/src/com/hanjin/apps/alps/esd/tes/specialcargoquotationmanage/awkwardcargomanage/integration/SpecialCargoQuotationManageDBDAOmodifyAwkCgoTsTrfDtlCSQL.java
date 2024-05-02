/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpecialCargoQuotationManageDBDAOmodifyAwkCgoTsTrfDtlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.05
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoQuotationManageDBDAOmodifyAwkCgoTsTrfDtlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyAwkCgoTsTrfDtl
	  * </pre>
	  */
	public SpecialCargoQuotationManageDBDAOmodifyAwkCgoTsTrfDtlCSQL(){
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
		params.put("lst_upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tml_act_cost_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cond_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aply_rto",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("calc_rmk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.integration").append("\n"); 
		query.append("FileName : SpecialCargoQuotationManageDBDAOmodifyAwkCgoTsTrfDtlCSQL").append("\n"); 
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
		query.append("INSERT INTO TES_AWK_CGO_TRF_DTL(" ).append("\n"); 
		query.append("YD_CD," ).append("\n"); 
		query.append("TML_AWK_CGO_TRF_TP_CD," ).append("\n"); 
		query.append("IO_BND_CD," ).append("\n"); 
		query.append("IO_GA_CD," ).append("\n"); 
		query.append("TML_AWK_TS_CD," ).append("\n"); 
		query.append("COND_NO," ).append("\n"); 
		query.append("TML_AWK_TRF_VER_NO," ).append("\n"); 
		query.append("TML_ACT_COST_SEQ," ).append("\n"); 
		query.append("APLY_RTO," ).append("\n"); 
		query.append("CALC_RMK," ).append("\n"); 
		query.append("LST_UPD_USR_ID," ).append("\n"); 
		query.append("LST_UPD_DT," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("@[yd_cd]," ).append("\n"); 
		query.append("@[tml_awk_cgo_trf_tp_cd]," ).append("\n"); 
		query.append("DECODE(UPPER(@[io_bnd_cd]),'DEFAULT','A',@[io_bnd_cd])," ).append("\n"); 
		query.append("DECODE(UPPER(@[io_ga_cd]),'DEFAULT','A','IN','I','OOG','O',@[io_ga_cd])," ).append("\n"); 
		query.append("DECODE(UPPER(@[tml_awk_ts_cd]),'DEFAULT','A','DIFF','D','SAME','S',@[tml_awk_ts_cd])," ).append("\n"); 
		query.append("@[cond_no]," ).append("\n"); 
		query.append("(SELECT NVL(MAX(TML_AWK_TRF_VER_NO),0)+1" ).append("\n"); 
		query.append("FROM TES_AWK_CGO_TRF_DTL" ).append("\n"); 
		query.append("WHERE YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("AND TML_AWK_CGO_TRF_TP_CD = @[tml_awk_cgo_trf_tp_cd]" ).append("\n"); 
		query.append("AND IO_BND_CD = DECODE(UPPER(@[io_bnd_cd]),'DEFAULT','A',@[io_bnd_cd])" ).append("\n"); 
		query.append("AND IO_GA_CD = DECODE(UPPER(@[io_ga_cd]),'DEFAULT','A','IN','I','OOG','O',@[io_ga_cd])" ).append("\n"); 
		query.append("AND TML_AWK_TS_CD = DECODE(UPPER(@[tml_awk_ts_cd]),'DEFAULT','A','DIFF','D','SAME','S',@[tml_awk_ts_cd])" ).append("\n"); 
		query.append("AND COND_NO = @[cond_no]" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("@[tml_act_cost_seq]," ).append("\n"); 
		query.append("@[aply_rto]," ).append("\n"); 
		query.append("@[calc_rmk]," ).append("\n"); 
		query.append("@[lst_upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("CASE WHEN (SELECT NVL(MAX(TML_AWK_TRF_VER_NO),0)+1" ).append("\n"); 
		query.append("FROM TES_AWK_CGO_TRF_DTL" ).append("\n"); 
		query.append("WHERE YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("AND TML_AWK_CGO_TRF_TP_CD = @[tml_awk_cgo_trf_tp_cd]" ).append("\n"); 
		query.append("AND IO_BND_CD = DECODE(UPPER(@[io_bnd_cd]),'DEFAULT','A',@[io_bnd_cd])" ).append("\n"); 
		query.append("AND IO_GA_CD = DECODE(UPPER(@[io_ga_cd]),'DEFAULT','A','IN','I','OOG','O',@[io_ga_cd])" ).append("\n"); 
		query.append("AND TML_AWK_TS_CD = DECODE(UPPER(@[tml_awk_ts_cd]),'DEFAULT','A','DIFF','D','SAME','S',@[tml_awk_ts_cd])" ).append("\n"); 
		query.append("AND COND_NO = @[cond_no]) > 1" ).append("\n"); 
		query.append("THEN" ).append("\n"); 
		query.append("(SELECT CRE_USR_ID" ).append("\n"); 
		query.append("FROM TES_AWK_CGO_TRF_DTL" ).append("\n"); 
		query.append("WHERE YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("AND TML_AWK_CGO_TRF_TP_CD = @[tml_awk_cgo_trf_tp_cd]" ).append("\n"); 
		query.append("AND IO_BND_CD = DECODE(UPPER(@[io_bnd_cd]),'DEFAULT','A',@[io_bnd_cd])" ).append("\n"); 
		query.append("AND IO_GA_CD = DECODE(UPPER(@[io_ga_cd]),'DEFAULT','A','IN','I','OOG','O',@[io_ga_cd])" ).append("\n"); 
		query.append("AND TML_AWK_TS_CD = DECODE(UPPER(@[tml_awk_ts_cd]),'DEFAULT','A','DIFF','D','SAME','S',@[tml_awk_ts_cd])" ).append("\n"); 
		query.append("AND COND_NO = @[cond_no]" ).append("\n"); 
		query.append("AND TML_AWK_TRF_VER_NO = (SELECT NVL(MAX(TML_AWK_TRF_VER_NO),0)" ).append("\n"); 
		query.append("FROM TES_AWK_CGO_TRF_DTL" ).append("\n"); 
		query.append("WHERE YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("AND TML_AWK_CGO_TRF_TP_CD = @[tml_awk_cgo_trf_tp_cd]" ).append("\n"); 
		query.append("AND IO_BND_CD = DECODE(UPPER(@[io_bnd_cd]),'DEFAULT','A',@[io_bnd_cd])" ).append("\n"); 
		query.append("AND IO_GA_CD = DECODE(UPPER(@[io_ga_cd]),'DEFAULT','A','IN','I','OOG','O',@[io_ga_cd])" ).append("\n"); 
		query.append("AND TML_AWK_TS_CD = DECODE(UPPER(@[tml_awk_ts_cd]),'DEFAULT','A','DIFF','D','SAME','S',@[tml_awk_ts_cd])" ).append("\n"); 
		query.append("AND COND_NO = @[cond_no]))" ).append("\n"); 
		query.append("ELSE (SELECT" ).append("\n"); 
		query.append("Y.OFC_CD CRE_USR_ID" ).append("\n"); 
		query.append("FROM MDM_YARD Y" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND Y.YD_CD LIKE @[yd_cd])" ).append("\n"); 
		query.append("END," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE)" ).append("\n"); 

	}
}