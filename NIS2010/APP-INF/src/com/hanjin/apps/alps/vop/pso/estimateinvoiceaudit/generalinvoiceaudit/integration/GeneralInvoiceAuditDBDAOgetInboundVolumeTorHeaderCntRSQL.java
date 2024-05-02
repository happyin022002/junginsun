/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOgetInboundVolumeTorHeaderCntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.03
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2014.03.03 이윤정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE YOUNJUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOgetInboundVolumeTorHeaderCntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * getInboundVolumeTorHeaderCnt
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOgetInboundVolumeTorHeaderCntRSQL(){
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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration ").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOgetInboundVolumeTorHeaderCntRSQL").append("\n"); 
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
		query.append("SELECT NVL( COUNT(H.VSL_CD) , 0 )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${budget_flag} == 'B') " ).append("\n"); 
		query.append("						FROM   VSK_BUD_VSL_PORT_SKD V, TDR_HEADER H" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("						FROM   VSK_VSL_PORT_SKD V, TDR_HEADER H" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("						WHERE  V.VSL_CD  = substr(@[vvd], 1, 4)" ).append("\n"); 
		query.append("						AND V.SKD_VOY_NO = substr(@[vvd], 5, 4)" ).append("\n"); 
		query.append("						AND V.SKD_DIR_CD = substr(@[vvd], 9)" ).append("\n"); 
		query.append("						AND    V.YD_CD        = @[yd_cd]" ).append("\n"); 
		query.append("						AND    V.VSL_CD       = H.VSL_CD" ).append("\n"); 
		query.append("						AND    V.SKD_VOY_NO   = H.VOY_NO" ).append("\n"); 
		query.append("						AND    V.SKD_DIR_CD   = H.DIR_CD" ).append("\n"); 
		query.append("						AND    V.VPS_PORT_CD  = H.PORT_CD" ).append("\n"); 
		query.append("						AND    V.CLPT_IND_SEQ = H.CALL_IND" ).append("\n"); 

	}
}