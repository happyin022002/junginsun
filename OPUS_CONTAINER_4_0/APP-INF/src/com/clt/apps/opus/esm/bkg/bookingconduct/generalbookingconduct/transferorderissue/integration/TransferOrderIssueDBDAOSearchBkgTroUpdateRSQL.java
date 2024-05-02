/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TransferOrderIssueDBDAOSearchBkgTroUpdateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.26
*@LastModifier : Maeda Atsushi
*@LastVersion : 1.0
* 2016.04.26 Maeda Atsushi
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maeda Atsushi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOSearchBkgTroUpdateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Check whether someone already updated the data or not
	  * </pre>
	  */
	public TransferOrderIssueDBDAOSearchBkgTroUpdateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_dt_old",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tro_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id_old",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOSearchBkgTroUpdateRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO " ).append("\n"); 
		query.append("FROM BKG_TRO" ).append("\n"); 
		query.append("WHERE 0=0" ).append("\n"); 
		query.append("AND BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND TRO_SEQ = @[tro_seq]" ).append("\n"); 
		query.append("#if (${upd_usr_id_old} != '')" ).append("\n"); 
		query.append("	AND UPPER(UPD_USR_ID) = @[upd_usr_id_old]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${upd_dt_old} != '')" ).append("\n"); 
		query.append("	AND TO_CHAR(UPD_DT, 'YYYY/MM/DD HH24:MI:SS') = @[upd_dt_old]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}