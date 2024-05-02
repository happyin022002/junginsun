/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EDISetupDBDAOSearchEdiGrpCgoCntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.28
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.01.28 이윤정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edisetup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee YounJung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EDISetupDBDAOSearchEdiGrpCgoCntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEdiGrpCgoCnt
	  * </pre>
	  */
	public EDISetupDBDAOSearchEdiGrpCgoCntRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_co_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_edi_stnd_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_edi_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_EDI_STS_SEQ",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edisetup.integration").append("\n"); 
		query.append("FileName : EDISetupDBDAOSearchEdiGrpCgoCntRSQL").append("\n"); 
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
		query.append("select  count(edi_grp_cd)" ).append("\n"); 
		query.append("from    edi_grp_cgo" ).append("\n"); 
		query.append("where" ).append("\n"); 
		query.append("1=1" ).append("\n"); 
		query.append("#if(${e_edi_grp_cd} != '')" ).append("\n"); 
		query.append("and edi_grp_cd      = @[e_edi_grp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${e_co_div_cd} != '')" ).append("\n"); 
		query.append("and     co_div_cd       = @[e_co_div_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${e_edi_stnd_sts_cd} != '')" ).append("\n"); 
		query.append("and     edi_stnd_sts_cd = @[e_edi_stnd_sts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${e_EDI_STS_SEQ} != '')" ).append("\n"); 
		query.append("and     EDI_STS_SEQ     = @[e_EDI_STS_SEQ]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}