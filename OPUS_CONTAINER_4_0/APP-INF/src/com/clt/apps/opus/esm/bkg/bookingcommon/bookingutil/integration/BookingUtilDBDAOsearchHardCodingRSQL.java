/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingUtilDBDAOsearchHardCodingRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.06.23 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Min Jeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOsearchHardCodingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SELECT
	  * </pre>
	  */
	public BookingUtilDBDAOsearchHardCodingRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt6",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hrd_cdg_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt4",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT" ).append("\n"); 
		query.append("HRD_CDG_ID" ).append("\n"); 
		query.append(",	HRD_CDG_ID_SEQ" ).append("\n"); 
		query.append(",	ATTR_CTNT1" ).append("\n"); 
		query.append(",	ATTR_CTNT2" ).append("\n"); 
		query.append(",	ATTR_CTNT3" ).append("\n"); 
		query.append(",	ATTR_CTNT4" ).append("\n"); 
		query.append(",	ATTR_CTNT5" ).append("\n"); 
		query.append(",	ATTR_CTNT6" ).append("\n"); 
		query.append(",	ATTR_CTNT7" ).append("\n"); 
		query.append(",	ATTR_CTNT8" ).append("\n"); 
		query.append(",	ATTR_CTNT9" ).append("\n"); 
		query.append(",	ATTR_CTNT10" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append("FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("WHERE	HRD_CDG_ID = @[hrd_cdg_id]" ).append("\n"); 
		query.append("#if (${attr_ctnt1} != '')" ).append("\n"); 
		query.append("AND  ATTR_CTNT1 = @[attr_ctnt1]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${attr_ctnt2} != '')" ).append("\n"); 
		query.append("AND  ATTR_CTNT2 = @[attr_ctnt2]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${attr_ctnt3} != '')" ).append("\n"); 
		query.append("AND  ATTR_CTNT3 = @[attr_ctnt3]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${attr_ctnt4} != '')" ).append("\n"); 
		query.append("AND  ATTR_CTNT4 = @[attr_ctnt4]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${attr_ctnt5} != '')" ).append("\n"); 
		query.append("AND  ATTR_CTNT5 = @[attr_ctnt5]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${attr_ctnt6} != '')" ).append("\n"); 
		query.append("AND  ATTR_CTNT6 = @[attr_ctnt6]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOsearchHardCodingRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}