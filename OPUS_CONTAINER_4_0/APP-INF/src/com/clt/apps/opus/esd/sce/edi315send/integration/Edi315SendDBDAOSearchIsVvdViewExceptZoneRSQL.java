/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : Edi315SendDBDAOSearchIsVvdViewExceptZoneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.19
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.02.19 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOSearchIsVvdViewExceptZoneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * for isVVD_View cursor
	  * </pre>
	  */
	public Edi315SendDBDAOSearchIsVvdViewExceptZoneRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_cop_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_cop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_edi_cgo_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_edi_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOSearchIsVvdViewExceptZoneRSQL").append("\n"); 
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
		query.append("SELECT COUNT(@[e_cop_no])  " ).append("\n"); 
		query.append("  FROM SCE_COP_DTL  " ).append("\n"); 
		query.append(" WHERE COP_NO = @[e_cop_no]" ).append("\n"); 
		query.append("   AND COP_DTL_SEQ < @[e_cop_dtl_seq]  " ).append("\n"); 
		query.append("   AND (LENGTH(NOD_CD) = 5 OR SUBSTR(NOD_CD,6,1) <> 'Z') --except Zone" ).append("\n"); 
		query.append("   AND STND_EDI_STS_CD IN ( SELECT DECODE(EDI_STND_STS_CD, 'VE', 'VAD', EDI_STND_STS_CD)" ).append("\n"); 
		query.append("                              FROM EDI_GRP_CGO" ).append("\n"); 
		query.append("                             WHERE EDI_CGO_RMK =@[e_edi_cgo_rmk]" ).append("\n"); 
		query.append("                               AND EDI_GRP_CD = @[e_edi_grp_cd]" ).append("\n"); 
		query.append("                          )" ).append("\n"); 

	}
}