/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ReceiveQueueMdmVendorCustomerGeneralDBDAOMergeMdmCustAddrFrmVndrCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.06
*@LastModifier : 양봉준
*@LastVersion : 1.0
* 2010.07.06 양봉준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Bongjun Yang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveQueueMdmVendorCustomerGeneralDBDAOMergeMdmCustAddrFrmVndrCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * vendor 입력시 mdm_cust_addr 정보를 insert / update 한다.
	  * </pre>
	  */
	public ReceiveQueueMdmVendorCustomerGeneralDBDAOMergeMdmCustAddrFrmVndrCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bzet_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_addr1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_addr3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bzet_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_addr2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eai_if_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("locl_addr4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eai_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.common.mdmSync.jms.integration").append("\n"); 
		query.append("FileName : ReceiveQueueMdmVendorCustomerGeneralDBDAOMergeMdmCustAddrFrmVndrCSQL").append("\n"); 
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
		query.append("MERGE INTO mdm_cust_addr a" ).append("\n"); 
		query.append("USING ( select @[cust_cnt_cd] cust_cnt_cd, @[cust_seq] cust_seq from dual ) b" ).append("\n"); 
		query.append("ON (a.cust_cnt_cd = b.cust_cnt_cd and a.cust_seq = b.cust_seq )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("update" ).append("\n"); 
		query.append("set" ).append("\n"); 
		query.append("PRMRY_CHK_FLG  = 'Y'," ).append("\n"); 
		query.append("upd_usr_id  = @[upd_usr_id]," ).append("\n"); 
		query.append("upd_dt      = to_date(@[upd_dt],'yyyymmddhh24miss')," ).append("\n"); 
		query.append("eai_evnt_dt = to_date(@[eai_evnt_dt],'yyyymmddhh24miss')," ).append("\n"); 
		query.append("bzet_addr   = @[bzet_addr]," ).append("\n"); 
		query.append("locl_addr1  = HJSEAI_PKG.h_decode(@[locl_addr1],'UTF8','UTF8')," ).append("\n"); 
		query.append("locl_addr2  = HJSEAI_PKG.h_decode(@[locl_addr2],'UTF8','UTF8')," ).append("\n"); 
		query.append("locl_addr3  = HJSEAI_PKG.h_decode(@[locl_addr3],'UTF8','UTF8')," ).append("\n"); 
		query.append("locl_addr4  = HJSEAI_PKG.h_decode(@[locl_addr4],'UTF8','UTF8')," ).append("\n"); 
		query.append("eai_if_id   = @[eai_if_id]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("insert" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("cust_cnt_cd," ).append("\n"); 
		query.append("cust_seq," ).append("\n"); 
		query.append("addr_tp_cd," ).append("\n"); 
		query.append("addr_seq," ).append("\n"); 
		query.append("PRMRY_CHK_FLG," ).append("\n"); 
		query.append("bzet_nm," ).append("\n"); 
		query.append("bzet_addr," ).append("\n"); 
		query.append("cre_usr_id," ).append("\n"); 
		query.append("cre_dt," ).append("\n"); 
		query.append("upd_usr_id," ).append("\n"); 
		query.append("upd_dt," ).append("\n"); 
		query.append("delt_flg," ).append("\n"); 
		query.append("eai_evnt_dt," ).append("\n"); 
		query.append("locl_addr1," ).append("\n"); 
		query.append("locl_addr2," ).append("\n"); 
		query.append("locl_addr3," ).append("\n"); 
		query.append("locl_addr4," ).append("\n"); 
		query.append("eai_if_id" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("values" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("@[cust_cnt_cd]," ).append("\n"); 
		query.append("@[cust_seq]," ).append("\n"); 
		query.append("'1'," ).append("\n"); 
		query.append("@[cust_seq]," ).append("\n"); 
		query.append("'Y'," ).append("\n"); 
		query.append("HJSEAI_PKG.h_decode(@[bzet_nm],'UTF8','UTF8')," ).append("\n"); 
		query.append("@[bzet_addr]," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("to_date(@[cre_dt],'yyyymmddhh24miss')," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("to_date(@[upd_dt],'yyyymmddhh24miss')," ).append("\n"); 
		query.append("'N'," ).append("\n"); 
		query.append("to_date(@[eai_evnt_dt],'yyyymmddhh24miss')," ).append("\n"); 
		query.append("HJSEAI_PKG.h_decode(@[locl_addr1],'UTF8','UTF8')," ).append("\n"); 
		query.append("HJSEAI_PKG.h_decode(@[locl_addr2],'UTF8','UTF8')," ).append("\n"); 
		query.append("HJSEAI_PKG.h_decode(@[locl_addr3],'UTF8','UTF8')," ).append("\n"); 
		query.append("HJSEAI_PKG.h_decode(@[locl_addr4],'UTF8','UTF8')," ).append("\n"); 
		query.append("@[eai_if_id]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}