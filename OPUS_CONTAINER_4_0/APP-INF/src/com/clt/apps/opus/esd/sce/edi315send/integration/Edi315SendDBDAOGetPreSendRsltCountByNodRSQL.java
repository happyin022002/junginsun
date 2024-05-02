/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : Edi315SendDBDAOGetPreSendRsltCountByNodRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.16
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.06.16 김성욱
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

public class Edi315SendDBDAOGetPreSendRsltCountByNodRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetPreSendRsltCountByNod
	  * </pre>
	  */
	public Edi315SendDBDAOGetPreSendRsltCountByNodRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOGetPreSendRsltCountByNodRSQL").append("\n"); 
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
		query.append("SELECT count(1) cnt" ).append("\n"); 
		query.append("  FROM SCE_EDI_MNG_AMS_STS M" ).append("\n"); 
		query.append("     , SCE_EDI_SND_RSLT R" ).append("\n"); 
		query.append("     , SCE_COP_HDR H" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND M.EDI_ORG_STS_CD = @[sts_cd]  " ).append("\n"); 
		query.append("   AND R.EDI_STS_CD IN (M.EDI_PRE_SNT_STS_CD,@[sts_cd])" ).append("\n"); 
		query.append("--   AND EDI_EVNT_STS_CD = 'AVN'" ).append("\n"); 
		query.append("   AND R.NOD_CD LIKE SUBSTR(@[nod_cd],1,5)||'%'" ).append("\n"); 
		query.append("   AND R.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND R.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("   AND R.BKG_NO = H.BKG_NO" ).append("\n"); 
		query.append("   AND R.CNTR_NO = H.CNTR_NO" ).append("\n"); 
		query.append("   AND M.EDI_ORG_STS_CD <> R.EDI_STS_CD" ).append("\n"); 

	}
}