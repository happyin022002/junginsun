/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingUtilDBDAOSearchClptIndSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.23
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOSearchClptIndSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Select slpt_ind_seq of speciffied vvd and yard
	  * </pre>
	  */
	public BookingUtilDBDAOSearchClptIndSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cltp_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchClptIndSeqRSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("	CLPT_IND_SEQ" ).append("\n"); 
		query.append("	,CLPT_IND_SEQ_MATCH" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT  CLPT_IND_SEQ" ).append("\n"); 
		query.append("		,CASE WHEN CLPT_IND_SEQ = NVL(@[cltp_ind_seq], 'X') THEN '1'" ).append("\n"); 
		query.append("              ELSE '0' END CLPT_IND_SEQ_MATCH" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE 0=0" ).append("\n"); 
		query.append("AND NVL(SKD_CNG_STS_CD,'A') <> 'S'" ).append("\n"); 
		query.append("AND VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("AND YD_CD = @[yd_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY CLPT_IND_SEQ_MATCH DESC " ).append("\n"); 

	}
}