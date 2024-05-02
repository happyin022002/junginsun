/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : Edi315SendDBDAOGetPreSentCntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.13
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.05.13 김성욱
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

public class Edi315SendDBDAOGetPreSentCntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetPreSentCnt
	  * </pre>
	  */
	public Edi315SendDBDAOGetPreSentCntRSQL(){
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
		params.put("edi_sts",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_edi_sts",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("edi_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOGetPreSentCntRSQL").append("\n"); 
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
		query.append("select count(*) cn from (" ).append("\n"); 
		query.append("    select 'Y' From sce_edi_snd_rslt " ).append("\n"); 
		query.append("    where 1=1" ).append("\n"); 
		query.append("    and bkg_no  = @[bkg_no]" ).append("\n"); 
		query.append("    and cntr_no = @[cntr_no]" ).append("\n"); 
		query.append("    and edi_grp_cd = @[edi_grp_cd]" ).append("\n"); 
		query.append("    AND EDI_STS_CD = @[org_edi_sts]" ).append("\n"); 
		query.append(") org_sts" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("    select 'Y' From sce_edi_snd_rslt " ).append("\n"); 
		query.append("    where 1=1" ).append("\n"); 
		query.append("    and bkg_no  = @[bkg_no]" ).append("\n"); 
		query.append("    and cntr_no = @[cntr_no]" ).append("\n"); 
		query.append("    and edi_grp_cd = @[edi_grp_cd]" ).append("\n"); 
		query.append("    AND EDI_STS_CD IN (SELECT EDI_PRE_SNT_STS_CD " ).append("\n"); 
		query.append("					  FROM  sce_edi_mng_ams_sts " ).append("\n"); 
		query.append("					  WHERE EDI_EVNT_STS_CD = @[edi_sts]" ).append("\n"); 
		query.append("					  AND   EDI_ORG_STS_CD  = @[org_edi_sts]" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}