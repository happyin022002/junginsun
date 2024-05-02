/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CustomerNominatedTruckerRgstDAOSearchSpNameByScacCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.27
*@LastModifier : DONG- IL, SHIN
*@LastVersion : 1.0
* 2015.02.27 DONG- IL, SHIN
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.cnt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerNominatedTruckerRgstDAOSearchSpNameByScacCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCAC CD로 S/P 정보 조회
	  * </pre>
	  */
	public CustomerNominatedTruckerRgstDAOSearchSpNameByScacCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usa_edi_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.codemanage.cnt.integration ").append("\n"); 
		query.append("FileName : CustomerNominatedTruckerRgstDAOSearchSpNameByScacCdRSQL").append("\n"); 
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
		query.append(" SELECT A.VNDR_SEQ" ).append("\n"); 
		query.append("       ,A.VNDR_LGL_ENG_NM AS VNDR_NM" ).append("\n"); 
		query.append("       ,A.USA_EDI_CD" ).append("\n"); 
		query.append("  FROM MDM_VENDOR A" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.USA_EDI_CD = @[usa_edi_cd]" ).append("\n"); 
		query.append("   AND A.DELT_FLG = 'N'" ).append("\n"); 

	}
}