/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BLIssuanceDBDAOSearchComboVVDInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    MDM.VSL_ENG_NM || ' ' ||VSK.OB_CSSM_VOY_NO AS name" ).append("\n"); 
		query.append("    ,VSL_PRE_PST_CD AS val" ).append("\n"); 
		query.append("  FROM BKG_VVD VVD" ).append("\n"); 
		query.append("      ,MDM_VSL_CNTR MDM" ).append("\n"); 
		query.append("	  ,VSK_VSL_PORT_SKD VSK" ).append("\n"); 
		query.append(" WHERE VVD.VSL_CD = MDM.VSL_CD" ).append("\n"); 
		query.append("   AND VVD.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if (${vsl_pre_pst_cd} == 'S')" ).append("\n"); 
		query.append("   AND VSL_PRE_PST_CD = 'S'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND VVD.VSL_CD = VSK.VSL_CD" ).append("\n"); 
		query.append("   AND VVD.SKD_VOY_NO = VSK.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND VVD.SKD_DIR_CD = VSK.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND VVD.POL_CD = VSK.VPS_PORT_CD" ).append("\n"); 
		query.append("   AND VVD.POL_CLPT_IND_SEQ = VSK.CLPT_IND_SEQ" ).append("\n"); 

	}
}