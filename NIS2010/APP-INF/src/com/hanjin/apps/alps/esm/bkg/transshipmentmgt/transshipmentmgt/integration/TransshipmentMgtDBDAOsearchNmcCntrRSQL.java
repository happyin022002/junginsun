/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TransshipmentMgtDBDAOsearchNmcCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransshipmentMgtDBDAOsearchNmcCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * NMC Container List 를 조회한다.
	  * </pre>
	  */
	public TransshipmentMgtDBDAOsearchNmcCntrRSQL(){
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.integration").append("\n"); 
		query.append("FileName : TransshipmentMgtDBDAOsearchNmcCntrRSQL").append("\n"); 
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
		query.append("SELECT CNTR_NO1" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT ROWNUM RNUM, CNTR_NO CNTR_NO1" ).append("\n"); 
		query.append("  FROM BKG_CONTAINER A, BKG_BOOKING B" ).append("\n"); 
		query.append(" WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("#if (${bkg_no} !='') " ).append("\n"); 
		query.append("  AND B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_no} !='') " ).append("\n"); 
		query.append("  AND B.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_no} !='') " ).append("\n"); 
		query.append("  AND A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" AND (" ).append("\n"); 
		query.append(" SELECT COUNT(CNTR_NO)" ).append("\n"); 
		query.append("   FROM BKG_CONTAINER A, BKG_BOOKING B" ).append("\n"); 
		query.append(" WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("#if (${bkg_no} !='') " ).append("\n"); 
		query.append("  AND B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_no} !='') " ).append("\n"); 
		query.append("  AND B.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_no} !='') " ).append("\n"); 
		query.append("  AND A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") > 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE RNUM != 1" ).append("\n"); 

	}
}