/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EBookingReceiptDBDAOchangeXterRqstStatusUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.03
*@LastModifier : Do Soon Choi
*@LastVersion : 1.0
* 2015.09.03 Do Soon Choi
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do Soon Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOchangeXterRqstStatusUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * changeXterRqstStatus
	  * </pre>
	  */
	public EBookingReceiptDBDAOchangeXterRqstStatusUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sender_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_upld_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOchangeXterRqstStatusUSQL").append("\n"); 
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
		query.append("UPDATE BKG_XTER_RQST_MST SET " ).append("\n"); 
		query.append("	BKG_UPLD_STS_CD = @[bkg_upld_sts_cd]" ).append("\n"); 
		query.append("    ,UPD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("    ,UPD_DT = sysdate" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_upld_sts_cd} == 'F') " ).append("\n"); 
		query.append("	,UPLD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("	,UPLD_DT = sysdate" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_upld_sts_cd} == 'D') " ).append("\n"); 
		query.append("	,RQST_DELT_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_upld_sts_cd} == 'N') " ).append("\n"); 
		query.append("	,RQST_DELT_FLG = 'N'" ).append("\n"); 
		query.append("	,SYS_UPLD_FLG ='N'" ).append("\n"); 
		query.append("	,SI_AUD_FLG = ''" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_upld_sts_cd} != 'F') " ).append("\n"); 
		query.append("	,XTER_RQST_STS_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("	,XTER_RQST_STS_CD = @[bkg_upld_sts_cd]" ).append("\n"); 
		query.append("    ,XTER_RQST_STS_UPD_DT = sysdate" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("AND	XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("AND	XTER_RQST_SEQ = @[rqst_seq]" ).append("\n"); 

	}
}