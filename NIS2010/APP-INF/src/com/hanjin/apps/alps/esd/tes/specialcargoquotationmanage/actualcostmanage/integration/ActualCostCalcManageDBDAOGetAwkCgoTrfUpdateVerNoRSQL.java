/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ActualCostCalcManageDBDAOGetAwkCgoTrfUpdateVerNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.15
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.actualcostmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ActualCostCalcManageDBDAOGetAwkCgoTrfUpdateVerNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * version no. 구하기
	  * </pre>
	  */
	public ActualCostCalcManageDBDAOGetAwkCgoTrfUpdateVerNoRSQL(){
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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tml_awk_cgo_trf_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.actualcostmanage.integration").append("\n"); 
		query.append("FileName : ActualCostCalcManageDBDAOGetAwkCgoTrfUpdateVerNoRSQL").append("\n"); 
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
		query.append("#if (${tml_awk_cgo_trf_tp_cd} == 'B' || ${tml_awk_cgo_trf_tp_cd} == 'T')" ).append("\n"); 
		query.append("SELECT NVL(MAX(TML_AWK_TRF_VER_NO),0)+1 VER_NO" ).append("\n"); 
		query.append("FROM TES_AWK_CGO_TRF_DTL" ).append("\n"); 
		query.append("WHERE YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("AND TML_AWK_CGO_TRF_TP_CD = @[tml_awk_cgo_trf_tp_cd]" ).append("\n"); 
		query.append("AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND IO_GA_CD = @[io_ga_cd]" ).append("\n"); 
		query.append("AND TML_AWK_TS_CD = @[tml_awk_ts_cd]" ).append("\n"); 
		query.append("AND COND_NO = @[cond_no]" ).append("\n"); 
		query.append("#elseif (${tml_awk_cgo_trf_tp_cd} == 'A')" ).append("\n"); 
		query.append("SELECT NVL(MAX(TML_AWK_ADON_VER_NO),0)+1 VER_NO" ).append("\n"); 
		query.append("FROM TES_AWK_CGO_ADON_HDR" ).append("\n"); 
		query.append("WHERE FM_LOC_CD = @[fm_loc_cd]" ).append("\n"); 
		query.append("AND FM_NOD_YD_NO = CASE WHEN @[fm_nod_yd_no] IS NULL" ).append("\n"); 
		query.append("THEN ' '" ).append("\n"); 
		query.append("ELSE NVL(TRIM(@[fm_nod_yd_no]), ' ')" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("AND TO_LOC_CD = @[to_loc_cd]" ).append("\n"); 
		query.append("AND TO_NOD_YD_NO = CASE WHEN @[to_nod_yd_no] IS NULL" ).append("\n"); 
		query.append("THEN ' '" ).append("\n"); 
		query.append("ELSE NVL(TRIM(@[to_nod_yd_no]), ' ')" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("AND COND_NO = @[cond_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}