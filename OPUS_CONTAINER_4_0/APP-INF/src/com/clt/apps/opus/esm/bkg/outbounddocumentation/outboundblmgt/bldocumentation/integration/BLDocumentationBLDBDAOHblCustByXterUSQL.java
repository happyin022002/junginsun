/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BLDocumentationBLDBDAOHblCustByXterUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.02
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.03.02 류대영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationBLDBDAOHblCustByXterUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * eBKG에서 Hbl customer 정보를 insert/update한다.
	  * </pre>
	  */
	public BLDocumentationBLDBDAOHblCustByXterUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_addr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hbl_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration ").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOHblCustByXterUSQL").append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("MERGE INTO BKG_HBL_CUST_HIS A" ).append("\n"); 
		query.append("USING DUAL ON (a.BKG_NO=@[bkg_no] AND A.CORR_NO='TMP0000001' AND A.HBL_SEQ=@[hbl_seq] AND A.BKG_CUST_TP_CD=@[bkg_cust_tp_cd])" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET CUST_NM = @[cust_nm]" ).append("\n"); 
		query.append(",	CUST_ADDR = @[cust_addr]" ).append("\n"); 
		query.append(",	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT = sysdate" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (BKG_NO" ).append("\n"); 
		query.append(",      CORR_NO" ).append("\n"); 
		query.append(",      HBL_SEQ" ).append("\n"); 
		query.append(",  	   BKG_CUST_TP_CD" ).append("\n"); 
		query.append(",      CUST_CNT_CD" ).append("\n"); 
		query.append(",  	   CUST_SEQ" ).append("\n"); 
		query.append(",      CUST_NM" ).append("\n"); 
		query.append(",      CUST_ADDR" ).append("\n"); 
		query.append(",      CRE_USR_ID" ).append("\n"); 
		query.append(",      CRE_DT" ).append("\n"); 
		query.append(",      UPD_USR_ID" ).append("\n"); 
		query.append(",      UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES(@[bkg_no]" ).append("\n"); 
		query.append(",   'TMP0000001'" ).append("\n"); 
		query.append(",	@[hbl_seq]" ).append("\n"); 
		query.append(",	@[bkg_cust_tp_cd]" ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	@[cust_nm]" ).append("\n"); 
		query.append(",	@[cust_addr]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("MERGE INTO BKG_HBL_CUST A" ).append("\n"); 
		query.append("USING DUAL ON (a.BKG_NO = @[bkg_no] AND	a.HBL_SEQ = @[hbl_seq] AND	a.BKG_CUST_TP_CD = @[bkg_cust_tp_cd])" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET CUST_NM = @[cust_nm]" ).append("\n"); 
		query.append(",	CUST_ADDR = @[cust_addr]" ).append("\n"); 
		query.append(",	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT = sysdate" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (BKG_NO" ).append("\n"); 
		query.append(",      HBL_SEQ" ).append("\n"); 
		query.append(",      BKG_CUST_TP_CD" ).append("\n"); 
		query.append(",      CUST_CNT_CD" ).append("\n"); 
		query.append(",      CUST_SEQ" ).append("\n"); 
		query.append(",      CUST_NM" ).append("\n"); 
		query.append(",      CUST_ADDR" ).append("\n"); 
		query.append(",      CRE_USR_ID" ).append("\n"); 
		query.append(",      CRE_DT" ).append("\n"); 
		query.append(",      UPD_USR_ID" ).append("\n"); 
		query.append(",      UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES(@[bkg_no]" ).append("\n"); 
		query.append(",   @[hbl_seq]" ).append("\n"); 
		query.append(",	@[bkg_cust_tp_cd]" ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	@[cust_nm]" ).append("\n"); 
		query.append(",	@[cust_addr]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}