/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KrWharfageDecMgtDBDAOsearchKrWhfSumAmtFmDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.26
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.10.26 정재엽
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Jae Yoeb
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KrWharfageDecMgtDBDAOsearchKrWhfSumAmtFmDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S
	  * </pre>
	  */
	public KrWharfageDecMgtDBDAOsearchKrWhfSumAmtFmDtlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whf_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration").append("\n"); 
		query.append("FileName : KrWharfageDecMgtDBDAOsearchKrWhfSumAmtFmDtlRSQL").append("\n"); 
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
		query.append("SUM(WHF_RT_AMT) AS WHF_AMT_FM_DTL" ).append("\n"); 
		query.append(",MAX(WHF_USR_NM) AS WHF_USR_NM" ).append("\n"); 
		query.append("FROM BKG_KR_WHF_VOL" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND VSL_CD      = SUBSTR( @[vvd],1,4 )" ).append("\n"); 
		query.append("AND SKD_VOY_NO  = SUBSTR( @[vvd],5,4 )" ).append("\n"); 
		query.append("AND SKD_DIR_CD  = SUBSTR( @[vvd],9,1 )" ).append("\n"); 
		query.append("AND PORT_CD       = @[port_cd]" ).append("\n"); 
		query.append("AND DECODE(SUBSTR(@[whf_bnd_cd],1,1),'I',SUBSTR(WHF_BND_CD,2,1),WHF_BND_CD) = DECODE(SUBSTR(@[whf_bnd_cd],1,1),'I',SUBSTR(@[whf_bnd_cd],2,1),@[whf_bnd_cd])" ).append("\n"); 

	}
}