/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TransferOrderIssueDBDAOSelectBkgTroActCustExistYnRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.27
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOSelectBkgTroActCustExistYnRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * E/Q Office Detail 체크 로직
	  * </pre>
	  */
	public TransferOrderIssueDBDAOSelectBkgTroActCustExistYnRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_act_rep_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration ").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOSelectBkgTroActCustExistYnRSQL").append("\n"); 
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
		query.append("SELECT DECODE(COUNT(*), 0, 'N','Y') AS EXIST_YN" ).append("\n"); 
		query.append("FROM BKG_TRO_ACT_CUST" ).append("\n"); 
		query.append("WHERE TRO_ACT_CUST_KND_CD = 'E'" ).append("\n"); 
		query.append("AND OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND TRO_ACT_REP_SEQ = @[tro_act_rep_seq]" ).append("\n"); 

	}
}