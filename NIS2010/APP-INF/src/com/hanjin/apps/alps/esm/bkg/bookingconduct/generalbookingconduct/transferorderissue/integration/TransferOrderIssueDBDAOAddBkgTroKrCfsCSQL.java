/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : TransferOrderIssueDBDAOAddBkgTroKrCfsCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.01.17
*@LastModifier : 
*@LastVersion : 1.0
* 2018.01.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOAddBkgTroKrCfsCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Create TRO KR CFS
	  * </pre>
	  */
	public TransferOrderIssueDBDAOAddBkgTroKrCfsCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration ").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOAddBkgTroKrCfsCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_TRO (" ).append("\n"); 
		query.append("	BKG_NO" ).append("\n"); 
		query.append(",	IO_BND_CD" ).append("\n"); 
		query.append(",	RTN_TRO_FLG" ).append("\n"); 
		query.append(",	TRO_SEQ" ).append("\n"); 
		query.append(",	RCV_TERM_CD" ).append("\n"); 
		query.append(", OWNR_TRK_FLG" ).append("\n"); 
		query.append(",	ACT_SHPR_CNT_CD" ).append("\n"); 
		query.append(",	ACT_SHPR_SEQ" ).append("\n"); 
		query.append(",	ACT_SHPR_NM" ).append("\n"); 
		query.append(",	ACT_SHPR_PHN_NO" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT)" ).append("\n"); 
		query.append("SELECT BB.BKG_NO" ).append("\n"); 
		query.append("       ,'O'" ).append("\n"); 
		query.append("       ,'N'" ).append("\n"); 
		query.append("       ,1" ).append("\n"); 
		query.append("       ,BB.RCV_TERM_CD" ).append("\n"); 
		query.append("       ,'Y'" ).append("\n"); 
		query.append("       ,BC.CUST_CNT_CD" ).append("\n"); 
		query.append("       ,BC.CUST_SEQ" ).append("\n"); 
		query.append("       ,MY.YD_NM" ).append("\n"); 
		query.append("       ,MY.PHN_NO" ).append("\n"); 
		query.append("       ,@[usr_id]" ).append("\n"); 
		query.append("       ,sysdate" ).append("\n"); 
		query.append("       ,@[usr_id]" ).append("\n"); 
		query.append("       ,sysdate" ).append("\n"); 
		query.append("FROM BKG_BOOKING BB" ).append("\n"); 
		query.append("     ,BKG_CUSTOMER BC" ).append("\n"); 
		query.append("     ,MDM_YARD MY" ).append("\n"); 
		query.append("WHERE BB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND   BB.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("AND   BC.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("AND   BB.FULL_RTN_YD_CD = MY.YD_CD" ).append("\n"); 
		query.append("AND   ROWNUM = 1" ).append("\n"); 

	}
}