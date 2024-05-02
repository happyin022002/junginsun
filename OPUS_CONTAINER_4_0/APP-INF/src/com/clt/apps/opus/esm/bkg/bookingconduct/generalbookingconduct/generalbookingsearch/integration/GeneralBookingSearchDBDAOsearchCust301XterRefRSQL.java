/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOsearchCust301XterRefRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.22
*@LastModifier : jklim
*@LastVersion : 1.0
* 2014.12.22 jklim
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jklim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOsearchCust301XterRefRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCust301XterRef
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOsearchCust301XterRefRSQL(){
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
		params.put("rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sender_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOsearchCust301XterRefRSQL").append("\n"); 
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
		query.append("SELECT '{I_BKG_REF'							          ||CHR(10)||" ).append("\n"); 
		query.append("       'IB_REF_CD:'		||REF.REF_CD				||CHR(10)||" ).append("\n"); 
		query.append("       'IB_REF_DESC:'	||REF.REF_CD_DESC		||CHR(10)||" ).append("\n"); 
		query.append("       'IB_REF_NO:'		||REF.REF_NO				||CHR(10)||" ).append("\n"); 
		query.append("       '}I_BKG_REF'  I_BKG_REF" ).append("\n"); 
		query.append("  FROM	BKG_XTER_REF REF" ).append("\n"); 
		query.append(" where xter_sndr_id = @[sender_id]" ).append("\n"); 
		query.append("   and xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("   and xter_rqst_seq= @[rqst_seq]" ).append("\n"); 
		query.append(" ORDER BY XTER_REF_SEQ" ).append("\n"); 

	}
}