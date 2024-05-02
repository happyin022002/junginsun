/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EqInterchangeDBDAOLseOnewayLoadPFMCDUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EqInterchangeDBDAOLseOnewayLoadPFMCDUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2016-04-11
	  * </pre>
	  */
	public EqInterchangeDBDAOLseOnewayLoadPFMCDUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_dol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mst_if",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mvmt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_mv_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.integration").append("\n"); 
		query.append("FileName : EqInterchangeDBDAOLseOnewayLoadPFMCDUSQL").append("\n"); 
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
		query.append("MERGE INTO LSE_ONEWAY_LOAD_PFMC A" ).append("\n"); 
		query.append("USING DUAL ON (A.CNTR_NO      = @[cntr_no]" ).append("\n"); 
		query.append("               AND A.AGMT_SEQ      = @[agmt_seq]" ).append("\n"); 
		query.append("               AND A.LSTM_CD = @[lstm_cd]" ).append("\n"); 
		query.append("               AND A.CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("               AND TO_CHAR(A.CNMV_DT,'YYYYMMDDHH24MISS') = @[cntr_mv_dt]" ).append("\n"); 
		query.append("               AND A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("               AND A.MVMT_SEARCH = @[mvmt]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED" ).append("\n"); 
		query.append("THEN UPDATE SET " ).append("\n"); 
		query.append("             A.DEL_DOL_YN   = @[del_dol]" ).append("\n"); 
		query.append("            ,A.IF_FLG           = @[mst_if]              " ).append("\n"); 
		query.append("     WHERE  1=1" ).append("\n"); 
		query.append("       AND A.CNTR_NO      = @[cntr_no]" ).append("\n"); 
		query.append("       AND A.AGMT_SEQ      = @[agmt_seq]" ).append("\n"); 
		query.append("       AND A.LSTM_CD = @[lstm_cd]" ).append("\n"); 
		query.append("       AND A.CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("       AND TO_CHAR(A.CNMV_DT,'YYYYMMDDHH24MISS') = @[cntr_mv_dt]" ).append("\n"); 
		query.append("       AND A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("       AND A.MVMT_SEARCH = @[mvmt]" ).append("\n"); 
		query.append("WHEN NOT MATCHED" ).append("\n"); 
		query.append("THEN INSERT (A.PFMC_SEQ" ).append("\n"); 
		query.append("            ,A.CNTR_NO" ).append("\n"); 
		query.append("            ,A.AGMT_CTY_CD" ).append("\n"); 
		query.append("            ,A.AGMT_SEQ" ).append("\n"); 
		query.append("            ,A.LSTM_CD" ).append("\n"); 
		query.append("            ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            ,A.CNMV_DT" ).append("\n"); 
		query.append("            ,A.MVMT_SEARCH" ).append("\n"); 
		query.append("            ,A.BKG_NO" ).append("\n"); 
		query.append("            ,A.DEL_DOL_YN" ).append("\n"); 
		query.append("            ,A.IF_FLG)" ).append("\n"); 
		query.append("     VALUES ((SELECT NVL(MAX(Z.PFMC_SEQ), 0) + 1 PFMC_SEQ" ).append("\n"); 
		query.append("              FROM   LSE_ONEWAY_LOAD_PFMC Z" ).append("\n"); 
		query.append("              WHERE  ROWNUM = 1)            " ).append("\n"); 
		query.append("            ,@[cntr_no]                " ).append("\n"); 
		query.append("            ,'HHO'        " ).append("\n"); 
		query.append("            ,@[agmt_seq]                    " ).append("\n"); 
		query.append("            ,@[lstm_cd]              " ).append("\n"); 
		query.append("            ,@[cntr_tpsz_cd]                    " ).append("\n"); 
		query.append("            ,TO_DATE(@[cntr_mv_dt], 'YYYYMMDDHH24MISS')                            " ).append("\n"); 
		query.append("            ,@[mvmt]                 " ).append("\n"); 
		query.append("            ,@[bkg_no]" ).append("\n"); 
		query.append("            ,@[del_dol]" ).append("\n"); 
		query.append("            ,@[mst_if]                   " ).append("\n"); 
		query.append("     )" ).append("\n"); 

	}
}