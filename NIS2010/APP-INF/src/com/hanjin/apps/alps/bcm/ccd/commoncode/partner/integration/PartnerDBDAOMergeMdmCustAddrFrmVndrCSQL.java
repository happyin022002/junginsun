/*=========================================================
*Copyright(c) 2018 SM Line
*@FileName : PartnerDBDAOMergeMdmCustAddrFrmVndrCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.partner.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerDBDAOMergeMdmCustAddrFrmVndrCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PartnerDBDAOMergeMdmCustAddrFrmVndrCSQL
	  * </pre>
	  */
	public PartnerDBDAOMergeMdmCustAddrFrmVndrCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("ib_flag",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bzet_addr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_addr4",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.ccd.commoncode.partner.integration").append("\n"); 
		query.append("FileName : PartnerDBDAOMergeMdmCustAddrFrmVndrCSQL").append("\n"); 
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
		query.append("MERGE INTO MDM_CUST_ADDR A " ).append("\n"); 
		query.append(" USING ( SELECT @[cust_cnt_cd] CUST_CNT_CD, @[cust_seq] CUST_SEQ FROM DUAL ) B" ).append("\n"); 
		query.append(" ON (A.CUST_CNT_CD = B.CUST_CNT_CD AND A.CUST_SEQ = B.CUST_SEQ )" ).append("\n"); 
		query.append(" WHEN MATCHED THEN" ).append("\n"); 
		query.append(" UPDATE SET" ).append("\n"); 
		query.append(" 	PRMRY_CHK_FLG  = 'Y'," ).append("\n"); 
		query.append(" 	UPD_USR_ID  = @[upd_usr_id]," ).append("\n"); 
		query.append(" 	UPD_DT      = SYSDATE," ).append("\n"); 
		query.append("	BZET_ADDR   = @[bzet_addr]," ).append("\n"); 
		query.append("	LOCL_ADDR1  = @[locl_addr1]," ).append("\n"); 
		query.append(" 	LOCL_ADDR2  = @[locl_addr2]," ).append("\n"); 
		query.append(" 	LOCL_ADDR3  = @[locl_addr3]," ).append("\n"); 
		query.append(" 	LOCL_ADDR4  = @[locl_addr4]," ).append("\n"); 
		query.append("    DELT_FLG = DECODE(NVL(@[ib_flag], 'U'), 'D', 'Y', 'N')" ).append("\n"); 
		query.append(" WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append(" INSERT" ).append("\n"); 
		query.append("	 (" ).append("\n"); 
		query.append("		CUST_CNT_CD," ).append("\n"); 
		query.append("		CUST_SEQ," ).append("\n"); 
		query.append("		ADDR_TP_CD," ).append("\n"); 
		query.append("		ADDR_SEQ," ).append("\n"); 
		query.append("		PRMRY_CHK_FLG," ).append("\n"); 
		query.append("		BZET_NM," ).append("\n"); 
		query.append("		BZET_ADDR," ).append("\n"); 
		query.append("		CRE_USR_ID," ).append("\n"); 
		query.append("		CRE_DT," ).append("\n"); 
		query.append("		UPD_USR_ID," ).append("\n"); 
		query.append("		UPD_DT," ).append("\n"); 
		query.append("		DELT_FLG," ).append("\n"); 
		query.append("		LOCL_ADDR1," ).append("\n"); 
		query.append("		LOCL_ADDR2," ).append("\n"); 
		query.append("		LOCL_ADDR3," ).append("\n"); 
		query.append("		LOCL_ADDR4" ).append("\n"); 
		query.append("	 )" ).append("\n"); 
		query.append("	 VALUES" ).append("\n"); 
		query.append("	 (" ).append("\n"); 
		query.append("		@[cust_cnt_cd]," ).append("\n"); 
		query.append("		@[cust_seq]," ).append("\n"); 
		query.append("		'1'," ).append("\n"); 
		query.append("		@[cust_seq]," ).append("\n"); 
		query.append("		'Y'," ).append("\n"); 
		query.append("		@[bzet_nm]," ).append("\n"); 
		query.append("		@[bzet_addr]," ).append("\n"); 
		query.append("		@[cre_usr_id]," ).append("\n"); 
		query.append("		SYSDATE," ).append("\n"); 
		query.append("		@[upd_usr_id]," ).append("\n"); 
		query.append("		SYSDATE," ).append("\n"); 
		query.append("		'N'," ).append("\n"); 
		query.append("		@[locl_addr1]," ).append("\n"); 
		query.append("		@[locl_addr2]," ).append("\n"); 
		query.append("		@[locl_addr3]," ).append("\n"); 
		query.append("		@[locl_addr4]" ).append("\n"); 
		query.append("	 )" ).append("\n"); 

	}
}