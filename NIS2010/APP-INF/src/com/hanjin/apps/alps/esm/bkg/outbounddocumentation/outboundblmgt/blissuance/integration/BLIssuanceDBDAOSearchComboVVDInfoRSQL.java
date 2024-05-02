/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLIssuanceDBDAOSearchComboVVDInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.21
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.07.21 이진서
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Jin Seo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOSearchComboVVDInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD 관련 정보를 가져온다.
	  * </pre>
	  */
	public BLIssuanceDBDAOSearchComboVVDInfoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOSearchComboVVDInfoRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("MDM.VSL_ENG_NM || ' ' ||SKD_VOY_NO || SKD_DIR_CD AS name" ).append("\n"); 
		query.append(",VSL_PRE_PST_CD AS val" ).append("\n"); 
		query.append("FROM BKG_VVD VVD" ).append("\n"); 
		query.append(",MDM_VSL_CNTR MDM" ).append("\n"); 
		query.append("WHERE VVD.VSL_CD = MDM.VSL_CD" ).append("\n"); 
		query.append("AND VVD.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if (${vsl_pre_pst_cd} == 'S')" ).append("\n"); 
		query.append("AND VSL_PRE_PST_CD = 'S'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}