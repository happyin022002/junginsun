/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLIssuanceDBDAOCanonEmlRmkCcnRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.10.14 김영출
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Youngchul
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOCanonEmlRmkCcnRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLIssuanceDBDAOCanonEmlRmkCcnRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration ").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOCanonEmlRmkCcnRSQL").append("\n"); 
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
		query.append("SELECT 'CCN : ' || B.CVY_REF_NO || C.BL_NO CCN" ).append("\n"); 
		query.append("FROM   BKG_VVD A, BKG_CSTMS_CND_VSL B, BKG_BOOKING C" ).append("\n"); 
		query.append("WHERE  A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("AND A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("AND C.BL_NO IS NOT NULL" ).append("\n"); 
		query.append("AND A.POD_CD IN (SELECT VPS_PORT_CD" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE  VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("AND SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("AND CLPT_IND_SEQ >= (SELECT MIN (CLPT_IND_SEQ)" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE  VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("AND SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("AND VPS_PORT_CD LIKE 'CA%'" ).append("\n"); 
		query.append("AND CLPT_IND_SEQ >= (SELECT MAX (CLPT_IND_SEQ)" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE  VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("AND SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("AND VPS_PORT_CD = A.POL_CD)))" ).append("\n"); 

	}
}