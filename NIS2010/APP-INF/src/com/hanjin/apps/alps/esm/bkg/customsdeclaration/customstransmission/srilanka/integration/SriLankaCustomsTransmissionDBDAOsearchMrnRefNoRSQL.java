/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SriLankaCustomsTransmissionDBDAOsearchMrnRefNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.30
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.srilanka.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SriLankaCustomsTransmissionDBDAOsearchMrnRefNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchMrnRefNo
	  * </pre>
	  */
	public SriLankaCustomsTransmissionDBDAOsearchMrnRefNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_number",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_pol",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.srilanka.integration").append("\n"); 
		query.append("FileName : SriLankaCustomsTransmissionDBDAOsearchMrnRefNoRSQL").append("\n"); 
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
		query.append("SELECT 	MSG_REF_NO" ).append("\n"); 
		query.append("FROM 	(	SELECT 	MSG_REF_NO, " ).append("\n"); 
		query.append("					RANK() OVER (PARTITION BY VSL_CD, SKD_VOY_NO, SKD_DIR_CD, PORT_CD ORDER BY CRE_DT DESC) RN" ).append("\n"); 
		query.append("  			FROM 	BKG_CSTMS_SRI_VVD" ).append("\n"); 
		query.append(" 			WHERE 	VSL_CD		= SUBSTR(@[vvd_number],1,4)" ).append("\n"); 
		query.append("   			AND 	SKD_VOY_NO	= SUBSTR(@[vvd_number],5,4)" ).append("\n"); 
		query.append("   			AND 	SKD_DIR_CD  = SUBSTR(@[vvd_number],9,1)" ).append("\n"); 
		query.append("			#if( ${io_bnd_cd} == 'I')" ).append("\n"); 
		query.append("			AND 	PORT_CD   	= @[vvd_pod]" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("			AND 	PORT_CD 	= @[vvd_pol]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("   			AND 	IO_BND_CD	= @[io_bnd_cd]	)" ).append("\n"); 
		query.append("WHERE 	RN 	= 1   " ).append("\n"); 

	}
}