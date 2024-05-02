/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOManageNVOFileNumberUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.25
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2015.02.25 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOManageNVOFileNumberUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOManageNVOFileNumberUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("usa_cstms_file_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scac_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_qty",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOManageNVOFileNumberUSQL").append("\n"); 
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
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("MERGE INTO BKG_USA_CSTMS_FILE_NO_HIS A" ).append("\n"); 
		query.append("USING DUAL ON (A.BKG_NO = @[bkg_no] AND A.CORR_NO = 'TMP0000001' AND A.USA_CSTMS_FILE_NO = @[usa_cstms_file_no])" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("	UPDATE SET " ).append("\n"); 
		query.append("			   PCK_QTY = nvl(@[pck_qty], 0)" ).append("\n"); 
		query.append("			 , SCAC_CD = @[scac_cd]" ).append("\n"); 
		query.append("			 , UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("			 , UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("	INSERT (BKG_NO" ).append("\n"); 
		query.append("			 , CORR_NO" ).append("\n"); 
		query.append("			 , USA_CSTMS_FILE_NO" ).append("\n"); 
		query.append("			 , PCK_QTY" ).append("\n"); 
		query.append("			 , SCAC_CD" ).append("\n"); 
		query.append("			 , CRE_USR_ID" ).append("\n"); 
		query.append("			 , CRE_DT" ).append("\n"); 
		query.append("			 , UPD_USR_ID" ).append("\n"); 
		query.append("			 , UPD_DT) " ).append("\n"); 
		query.append("	VALUES (@[bkg_no]" ).append("\n"); 
		query.append("			 , 'TMP0000001'" ).append("\n"); 
		query.append("			 , @[usa_cstms_file_no]" ).append("\n"); 
		query.append("			 , nvl(@[pck_qty], 0)" ).append("\n"); 
		query.append("			 , @[scac_cd]" ).append("\n"); 
		query.append("			 , @[cre_usr_id]" ).append("\n"); 
		query.append("			 , SYSDATE" ).append("\n"); 
		query.append("			 , @[upd_usr_id]" ).append("\n"); 
		query.append("			 , SYSDATE)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("MERGE INTO BKG_USA_CSTMS_FILE_NO A" ).append("\n"); 
		query.append("USING DUAL ON (A.BKG_NO = @[bkg_no] AND A.USA_CSTMS_FILE_NO = @[usa_cstms_file_no])" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("	UPDATE SET " ).append("\n"); 
		query.append("			   PCK_QTY = nvl(@[pck_qty], 0)" ).append("\n"); 
		query.append("			 , SCAC_CD = @[scac_cd]" ).append("\n"); 
		query.append("			 , UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("			 , UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("	INSERT (BKG_NO" ).append("\n"); 
		query.append("			 , USA_CSTMS_FILE_NO" ).append("\n"); 
		query.append("			 , PCK_QTY" ).append("\n"); 
		query.append("			 , SCAC_CD" ).append("\n"); 
		query.append("			 , CRE_USR_ID" ).append("\n"); 
		query.append("			 , CRE_DT" ).append("\n"); 
		query.append("			 , UPD_USR_ID" ).append("\n"); 
		query.append("			 , UPD_DT) " ).append("\n"); 
		query.append("	VALUES (@[bkg_no]" ).append("\n"); 
		query.append("			 , @[usa_cstms_file_no]" ).append("\n"); 
		query.append("			 , nvl(@[pck_qty], 0)" ).append("\n"); 
		query.append("			 , @[scac_cd]" ).append("\n"); 
		query.append("			 , @[cre_usr_id]" ).append("\n"); 
		query.append("			 , SYSDATE" ).append("\n"); 
		query.append("			 , @[upd_usr_id]" ).append("\n"); 
		query.append("			 , SYSDATE)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}