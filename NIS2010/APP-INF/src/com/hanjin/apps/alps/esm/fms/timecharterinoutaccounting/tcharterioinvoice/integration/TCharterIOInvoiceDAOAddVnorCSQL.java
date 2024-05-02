/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOInvoiceDAOAddVnorCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.25
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.03.25 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOInvoiceDAOAddVnorCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FMS VNOR 입력
	  * </pre>
	  */
	public TCharterIOInvoiceDAOAddVnorCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vnor_offh_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vnor_offh_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vnor_fm_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vnor_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vnor_vsl_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vnor_offh_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vnor_offh_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vnor_to_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_chk_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDAOAddVnorCSQL").append("\n"); 
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
		query.append("INSERT INTO FMS_VNOR" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append(" VSL_CD" ).append("\n"); 
		query.append(",VNOR_SEQ" ).append("\n"); 
		query.append(",VNOR_OFFH_FM_DT" ).append("\n"); 
		query.append(",VNOR_OFFH_TO_DT" ).append("\n"); 
		query.append(",CR_CHK_FLG" ).append("\n"); 
		query.append(",SKD_VOY_NO" ).append("\n"); 
		query.append(",SKD_DIR_CD" ).append("\n"); 
		query.append(",VNOR_OFFH_KND_CD" ).append("\n"); 
		query.append(",VNOR_OFFH_TP_CD" ).append("\n"); 
		query.append(",VNOR_VSL_STS_CD" ).append("\n"); 
		query.append(",VNOR_FM_PORT_CD" ).append("\n"); 
		query.append(",VNOR_TO_PORT_CD" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append(" @[vsl_cd] AS VSL_CD" ).append("\n"); 
		query.append(",@[vnor_seq] AS VNOR_SEQ" ).append("\n"); 
		query.append(",TO_DATE(@[vnor_offh_fm_dt],'YYYYMMDDHH24MI') AS VNOR_OFFH_FM_DT" ).append("\n"); 
		query.append(",TO_DATE(@[vnor_offh_to_dt],'YYYYMMDDHH24MI') AS VNOR_OFFH_TO_DT" ).append("\n"); 
		query.append(",@[cr_chk_flg] AS CR_CHK_FLG" ).append("\n"); 
		query.append(",@[skd_voy_no] AS SKD_VOY_NO" ).append("\n"); 
		query.append(",@[skd_dir_cd] AS SKD_DIR_CD" ).append("\n"); 
		query.append(",@[vnor_offh_knd_cd] AS VNOR_OFFH_KND_CD" ).append("\n"); 
		query.append(",@[vnor_offh_tp_cd] AS VNOR_OFFH_TP_CD" ).append("\n"); 
		query.append(",@[vnor_vsl_sts_cd] AS VNOR_VSL_STS_CD" ).append("\n"); 
		query.append(",@[vnor_fm_port_cd] AS VNOR_FM_PORT_CD" ).append("\n"); 
		query.append(",@[vnor_to_port_cd] AS VNOR_TO_PORT_CD" ).append("\n"); 
		query.append(",@[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append(",SYSDATE AS CRE_DT" ).append("\n"); 
		query.append(",@[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append(",SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}