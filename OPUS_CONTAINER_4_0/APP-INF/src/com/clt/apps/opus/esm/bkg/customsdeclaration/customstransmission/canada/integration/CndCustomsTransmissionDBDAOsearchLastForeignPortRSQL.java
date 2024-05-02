/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CndCustomsTransmissionDBDAOsearchLastForeignPortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.18
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.11.18 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndCustomsTransmissionDBDAOsearchLastForeignPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * transmit. BayPlanCntrDetailVO
	  * </pre>
	  */
	public CndCustomsTransmissionDBDAOsearchLastForeignPortRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.integration").append("\n"); 
		query.append("FileName : CndCustomsTransmissionDBDAOsearchLastForeignPortRSQL").append("\n"); 
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
		query.append("SELECT     XX.VPS_PORT_CD" ).append("\n"); 
		query.append("          ,XX.CLPT_IND_SEQ" ).append("\n"); 
		query.append("		  ,XX.LASTPOL" ).append("\n"); 
		query.append("		  ,XX.LPOL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("          ,LASTPOL||' '||LPOL_CLPT_IND_SEQ AS TMP1" ).append("\n"); 
		query.append("FROM      (" ).append("\n"); 
		query.append("          ------------------------------------------------------------" ).append("\n"); 
		query.append("          SELECT    PS.VSL_CD" ).append("\n"); 
		query.append("                 ,  PS.SKD_VOY_NO" ).append("\n"); 
		query.append("                 ,  PS.SKD_DIR_CD" ).append("\n"); 
		query.append("                 ,  LAG(PS.VPS_PORT_CD     ,1) OVER (PARTITION BY PS.VSL_CD,PS.SKD_VOY_NO,PS.SKD_DIR_CD ORDER BY DECODE(PS.SKD_CNG_STS_CD,'S',9,1) ASC, DECODE(PS.VPS_PORT_CD,'EGSCA',9,'PAPCA',9,1) ASC, PS.CLPT_SEQ ASC) LASTPOL" ).append("\n"); 
		query.append("                 ,  PS.VPS_PORT_CD" ).append("\n"); 
		query.append("                 ,  LAG(PS.CLPT_IND_SEQ    ,1) OVER (PARTITION BY PS.VSL_CD,PS.SKD_VOY_NO,PS.SKD_DIR_CD ORDER BY DECODE(PS.SKD_CNG_STS_CD,'S',9,1) ASC, DECODE(PS.VPS_PORT_CD,'EGSCA',9,'PAPCA',9,1) ASC, PS.CLPT_SEQ ASC) LPOL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                 ,  PS.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                 ,  LAG(PS.CLPT_SEQ        ,1) OVER (PARTITION BY PS.VSL_CD,PS.SKD_VOY_NO,PS.SKD_DIR_CD ORDER BY DECODE(PS.SKD_CNG_STS_CD,'S',9,1) ASC, DECODE(PS.VPS_PORT_CD,'EGSCA',9,'PAPCA',9,1) ASC, PS.CLPT_SEQ ASC) LPOL_CLPT_SEQ" ).append("\n"); 
		query.append("                 ,  PS.CLPT_SEQ" ).append("\n"); 
		query.append("                 ,  PS.TURN_PORT_FLG" ).append("\n"); 
		query.append("                 ,  LAG(PS.TURN_PORT_IND_CD,1) OVER (PARTITION BY PS.VSL_CD,PS.SKD_VOY_NO,PS.SKD_DIR_CD ORDER BY DECODE(PS.SKD_CNG_STS_CD,'S',9,1) ASC, DECODE(PS.VPS_PORT_CD,'EGSCA',9,'PAPCA',9,1) ASC, PS.CLPT_SEQ ASC) LPOL_TURN_PORT_IND_CD" ).append("\n"); 
		query.append("                 ,  PS.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("          FROM      VSK_VSL_PORT_SKD               PS" ).append("\n"); 
		query.append("          WHERE     PS.VSL_CD                      = SUBSTR(@[vvd],1,4)  -- Need to bind Vessel Code    --" ).append("\n"); 
		query.append("          AND       PS.SKD_VOY_NO                  = SUBSTR(@[vvd],5,4)  -- Need to bind Voyage Number  --" ).append("\n"); 
		query.append("          AND       PS.SKD_DIR_CD                  = SUBSTR(@[vvd],9,1)     -- Need to bind Direction Code --" ).append("\n"); 
		query.append("          AND       NVL(PS.VT_ADD_CALL_FLG,'N')    <> 'Y'" ).append("\n"); 
		query.append("          AND       NVL(PS.SKD_CNG_STS_CD ,'*')    <> 'S'" ).append("\n"); 
		query.append("          AND       PS.VPS_PORT_CD                 NOT IN ('EGSCA','PAPCA')" ).append("\n"); 
		query.append("          ------------------------------------------------------------" ).append("\n"); 
		query.append("          ) XX" ).append("\n"); 
		query.append("WHERE     1 = 1" ).append("\n"); 
		query.append("AND       XX.VPS_PORT_CD                 LIKE 'CA%'" ).append("\n"); 
		query.append("AND       SUBSTR(XX.VPS_PORT_CD,1,2)     <> SUBSTR(XX.LASTPOL,1,2)  " ).append("\n"); 
		query.append("AND       XX.LPOL_TURN_PORT_IND_CD       IN ('Y','N')" ).append("\n"); 
		query.append("ORDER BY  XX.CLPT_IND_SEQ            ASC" ).append("\n"); 

	}
}