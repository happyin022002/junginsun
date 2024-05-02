/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KrWharfageDecMgtDBDAOsearchKrWhfBlkPortRtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.10.12 정재엽
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Jae Yoeb
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KrWharfageDecMgtDBDAOsearchKrWhfBlkPortRtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * s
	  * </pre>
	  */
	public KrWharfageDecMgtDBDAOsearchKrWhfBlkPortRtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("whf_vol_dc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whf_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration ").append("\n"); 
		query.append("FileName : KrWharfageDecMgtDBDAOsearchKrWhfBlkPortRtRSQL").append("\n"); 
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
		query.append("SELECT A.TEU_PRC AS BLK_UT_RT," ).append("\n"); 
		query.append("(1 - A.TEU_AMT_RT) AS BLK_RT_RTO" ).append("\n"); 
		query.append("FROM BKG_KR_WHF_PORT_RT A" ).append("\n"); 
		query.append("WHERE A.CNTR_BLK_DIV_CD = 'B'" ).append("\n"); 
		query.append("AND A.PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("AND A.IO_BND_CD = SUBSTR(@[whf_bnd_cd], 1, 1)" ).append("\n"); 
		query.append("AND A.DC_RTO_NO = (SELECT NVL(TRIM(MAX(B.DC_RTO_NO)), '0')" ).append("\n"); 
		query.append("FROM BKG_KR_WHF_PORT_RT B" ).append("\n"); 
		query.append("WHERE B.CNTR_BLK_DIV_CD = A.CNTR_BLK_DIV_CD" ).append("\n"); 
		query.append("AND B.PORT_CD = A.PORT_CD" ).append("\n"); 
		query.append("AND B.DC_RTO_NO = @[whf_vol_dc_cd])" ).append("\n"); 

	}
}