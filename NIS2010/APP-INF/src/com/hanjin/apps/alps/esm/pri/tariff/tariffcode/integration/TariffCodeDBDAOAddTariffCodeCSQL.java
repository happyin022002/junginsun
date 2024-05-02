/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TariffCodeDBDAOAddTariffCodeCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.09
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2014.06.09 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.tariffcode.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sunghwan Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TariffCodeDBDAOAddTariffCodeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Tariff 생성
	  * </pre>
	  */
	public TariffCodeDBDAOAddTariffCodeCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_pfx_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_orz_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("web_dp_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trf_orz_tp_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_inlnd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.tariffcode.integration").append("\n"); 
		query.append("FileName : TariffCodeDBDAOAddTariffCodeCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_TARIFF(" ).append("\n"); 
		query.append("            TRF_PFX_CD," ).append("\n"); 
		query.append("            TRF_NO," ).append("\n"); 
		query.append("            TRF_NM," ).append("\n"); 
		query.append("            TRF_ORZ_NM," ).append("\n"); 
		query.append("            TRF_ORZ_TP_NM," ).append("\n"); 
		query.append("			TRF_INLND_FLG," ).append("\n"); 
		query.append("			WEB_DP_FLG," ).append("\n"); 
		query.append("            CRE_USR_ID," ).append("\n"); 
		query.append("            CRE_DT," ).append("\n"); 
		query.append("            UPD_USR_ID," ).append("\n"); 
		query.append("            UPD_DT)              " ).append("\n"); 
		query.append("       VALUES(" ).append("\n"); 
		query.append("            SUBSTR(@[trf_pfx_cd],1,4)," ).append("\n"); 
		query.append("            @[trf_no]," ).append("\n"); 
		query.append("            @[trf_nm]," ).append("\n"); 
		query.append("            @[trf_orz_nm]," ).append("\n"); 
		query.append("            @[trf_orz_tp_nm]," ).append("\n"); 
		query.append("			@[trf_inlnd_flg]," ).append("\n"); 
		query.append("			NVL(@[web_dp_flg], 'Y'), " ).append("\n"); 
		query.append("            @[cre_usr_id]," ).append("\n"); 
		query.append("            SYSDATE," ).append("\n"); 
		query.append("            @[upd_usr_id]," ).append("\n"); 
		query.append("            SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}