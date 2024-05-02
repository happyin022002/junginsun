/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOaddOrgPartyListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.09
*@LastModifier : 이영헌
*@LastVersion : 1.0
* 2012.07.09 이영헌
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YoungHeon Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOaddOrgPartyListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SNP/Broker Nomination  Data insert
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOaddOrgPartyListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_pty_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_yd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_pty_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_pty_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_yd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOaddOrgPartyListCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_ADV_ORZ_PTY" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("  CUST_CNT_CD," ).append("\n"); 
		query.append("  CUST_SEQ," ).append("\n"); 
		query.append("  SC_NO," ).append("\n"); 
		query.append("  POD_CD," ).append("\n"); 
		query.append("  POD_YD_NO," ).append("\n"); 
		query.append("  DEL_CD," ).append("\n"); 
		query.append("  DEL_YD_NO," ).append("\n"); 
		query.append("  CSTMS_PTY_SEQ," ).append("\n"); 
		query.append("  CSTMS_PTY_TP_CD," ).append("\n"); 
		query.append("  CSTMS_PTY_ID," ).append("\n"); 
		query.append("  CSTMS_PTY_NM," ).append("\n"); 
		query.append("  DELT_FLG," ).append("\n"); 
		query.append("  CRE_OFC_CD," ).append("\n"); 
		query.append("  UPD_OFC_CD," ).append("\n"); 
		query.append("  CRE_USR_ID," ).append("\n"); 
		query.append("  CRE_DT," ).append("\n"); 
		query.append("  UPD_USR_ID," ).append("\n"); 
		query.append("  UPD_DT " ).append("\n"); 
		query.append(" )" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append(" (" ).append("\n"); 
		query.append("  SUBSTR(@[cust_cd],1,2)," ).append("\n"); 
		query.append("  TO_NUMBER(SUBSTR(@[cust_cd],3,6))," ).append("\n"); 
		query.append("  @[sc_no]," ).append("\n"); 
		query.append("  @[pod_cd]," ).append("\n"); 
		query.append("  @[pod_yd_no]," ).append("\n"); 
		query.append("  @[del_cd]," ).append("\n"); 
		query.append("  @[del_yd_no]," ).append("\n"); 
		query.append("  (SELECT NVL(MAX(CSTMS_PTY_SEQ),0)+1 " ).append("\n"); 
		query.append("   FROM BKG_CSTMS_ADV_ORZ_PTY)," ).append("\n"); 
		query.append("  @[cstms_pty_tp_cd]," ).append("\n"); 
		query.append("  @[cstms_pty_id]," ).append("\n"); 
		query.append("  @[cstms_pty_nm]," ).append("\n"); 
		query.append("  @[delt_flg]," ).append("\n"); 
		query.append("  @[cre_ofc_cd]," ).append("\n"); 
		query.append("  @[upd_ofc_cd]," ).append("\n"); 
		query.append("  @[cre_usr_id]," ).append("\n"); 
		query.append("  sysdate," ).append("\n"); 
		query.append("  @[upd_usr_id]," ).append("\n"); 
		query.append("  sysdate      " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}