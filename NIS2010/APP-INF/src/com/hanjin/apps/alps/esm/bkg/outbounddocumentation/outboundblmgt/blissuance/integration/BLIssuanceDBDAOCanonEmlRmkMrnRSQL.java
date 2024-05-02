/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLIssuanceDBDAOCanonEmlRmkMrnRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.10.14 김영출
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Youngchul
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOCanonEmlRmkMrnRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLIssuanceDBDAOCanonEmlRmkMrnRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration ").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOCanonEmlRmkMrnRSQL").append("\n"); 
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
		query.append("SELECT 'MRN # : ' || MRN.MRN_NO || MRN.MRN_CHK_NO RMK_MRN" ).append("\n"); 
		query.append("FROM   BKG_BOOKING BK, BKG_VVD BV, BKG_CSTMS_KR_MF_REF_NO MRN" ).append("\n"); 
		query.append("WHERE  BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BK.POR_CD LIKE 'KR%'" ).append("\n"); 
		query.append("AND BK.POL_CD = MRN.PORT_CD" ).append("\n"); 
		query.append("AND BK.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("AND BV.VSL_CD = MRN.VSL_CD" ).append("\n"); 
		query.append("AND BV.SKD_VOY_NO = MRN.SKD_VOY_NO" ).append("\n"); 
		query.append("AND BV.SKD_DIR_CD = MRN.SKD_DIR_CD" ).append("\n"); 
		query.append("AND BV.POL_CD = MRN.PORT_CD" ).append("\n"); 
		query.append("AND MRN.IO_BND_CD = 'O'" ).append("\n"); 

	}
}