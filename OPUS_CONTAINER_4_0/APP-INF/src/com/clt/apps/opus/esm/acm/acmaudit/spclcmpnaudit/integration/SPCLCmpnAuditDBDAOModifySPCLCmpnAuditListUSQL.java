/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SPCLCmpnAuditDBDAOModifySPCLCmpnAuditListUSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.06
*@LastModifier :
*@LastVersion : 1.0
* 2012.07.06
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmaudit.spclcmpnaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SPCLCmpnAuditDBDAOModifySPCLCmpnAuditListUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * ModifySPCLCmpnAuditList
	  * </pre>
	  */
	public SPCLCmpnAuditDBDAOModifySPCLCmpnAuditListUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cmpn_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("spcl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_chk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmaudit.spclcmpnaudit.integration").append("\n");
		query.append("FileName : SPCLCmpnAuditDBDAOModifySPCLCmpnAuditListUSQL").append("\n");
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
		query.append("UPDATE ACM_SPCL_CMPN" ).append("\n");
		query.append("   SET  " ).append("\n");
		query.append("        PAY_CHK_FLG		= DECODE(@[pay_chk],'1','Y','N')," ).append("\n");
		query.append("        PAY_CHK_USR_ID  = DECODE(@[pay_chk],'1',@[usr_id],NULL)," ).append("\n");
		query.append("        PAY_CHK_DT		= DECODE(@[pay_chk],'1',SYSDATE,NULL)," ).append("\n");
		query.append("        PAY_CHK_GDT		= DECODE(@[pay_chk],'1',GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE,'GMT'),NULL)," ).append("\n");
		query.append("        UPD_USR_ID 		= @[usr_id]," ).append("\n");
		query.append("        UPD_DT 			= SYSDATE" ).append("\n");
		query.append(" WHERE BKG_NO           = @[bkg_no]" ).append("\n");
		query.append("   AND SPCL_OFC_CD      = @[spcl_ofc_cd]" ).append("\n");
		query.append("   AND SPCL_CMPN_SEQ    = @[spcl_cmpn_seq]" ).append("\n");
		query.append("   AND SPCL_AGMT_SEQ    = @[spcl_agmt_seq]" ).append("\n");
		query.append("   AND CUST_CNT_CD      = @[cust_cnt_cd]" ).append("\n");

	}
}