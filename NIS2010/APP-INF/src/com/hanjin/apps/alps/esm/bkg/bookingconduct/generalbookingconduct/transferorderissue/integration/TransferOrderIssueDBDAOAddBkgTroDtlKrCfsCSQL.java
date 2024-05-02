/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : TransferOrderIssueDBDAOAddBkgTroDtlKrCfsCSQL.java
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

public class TransferOrderIssueDBDAOAddBkgTroDtlKrCfsCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRO DTL KR CFS
	  * </pre>
	  */
	public TransferOrderIssueDBDAOAddBkgTroDtlKrCfsCSQL(){
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
		query.append("FileName : TransferOrderIssueDBDAOAddBkgTroDtlKrCfsCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_TRO_DTL (" ).append("\n"); 
		query.append("	BKG_NO" ).append("\n"); 
		query.append(",	IO_BND_CD" ).append("\n"); 
		query.append(",	RTN_TRO_FLG" ).append("\n"); 
		query.append(",	TRO_SEQ" ).append("\n"); 
		query.append(",	TRO_SUB_SEQ" ).append("\n"); 
		query.append(",	CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	TRO_QTY" ).append("\n"); 
		query.append(",	DOR_ARR_DT" ).append("\n"); 
		query.append(",	PKUP_LOC_CD" ).append("\n"); 
		query.append(",	PKUP_YD_CD" ).append("\n"); 
		query.append(",	RTN_LOC_CD" ).append("\n"); 
		query.append(",	RTN_YD_CD" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT BQ.BKG_NO" ).append("\n"); 
		query.append("       ,'O'" ).append("\n"); 
		query.append("       ,'N'" ).append("\n"); 
		query.append("       ,1" ).append("\n"); 
		query.append("       ,ROWNUM" ).append("\n"); 
		query.append("       ,BQ.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       ,BQ.OP_CNTR_QTY" ).append("\n"); 
		query.append("       ,SYSDATE" ).append("\n"); 
		query.append("       ,SUBSTR(BB.MTY_PKUP_YD_CD,1,5)" ).append("\n"); 
		query.append("       ,BB.MTY_PKUP_YD_CD" ).append("\n"); 
		query.append("       ,SUBSTR(BB.FULL_RTN_YD_CD,1,5)" ).append("\n"); 
		query.append("       ,BB.FULL_RTN_YD_CD" ).append("\n"); 
		query.append("       ,@[usr_id]" ).append("\n"); 
		query.append("       ,sysdate" ).append("\n"); 
		query.append("       ,@[usr_id]" ).append("\n"); 
		query.append("       ,sysdate" ).append("\n"); 
		query.append("FROM BKG_BOOKING BB" ).append("\n"); 
		query.append("     ,BKG_QUANTITY BQ" ).append("\n"); 
		query.append("WHERE BB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BB.BKG_NO = BQ.BKG_NO" ).append("\n"); 

	}
}