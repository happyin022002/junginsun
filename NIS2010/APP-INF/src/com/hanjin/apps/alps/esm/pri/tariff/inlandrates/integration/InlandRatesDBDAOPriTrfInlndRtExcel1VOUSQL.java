/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InlandRatesDBDAOPriTrfInlndRtExcel1VOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.07
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.12.07 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.inlandrates.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNGMIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandRatesDBDAOPriTrfInlndRtExcel1VOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 엑셀업로드시 amend delete처리한다.
	  * </pre>
	  */
	public InlandRatesDBDAOPriTrfInlndRtExcel1VOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_inlnd_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_pfx_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.inlandrates.integration ").append("\n"); 
		query.append("FileName : InlandRatesDBDAOPriTrfInlndRtExcel1VOUSQL").append("\n"); 
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
		query.append("UPDATE PRI_TRF_INLND_RT" ).append("\n"); 
		query.append("   SET UPD_USR_ID                  = @[upd_usr_id]" ).append("\n"); 
		query.append("     , UPD_DT                      = SYSDATE" ).append("\n"); 
		query.append("	 , SRC_INFO_CD     			   = 'AD'" ).append("\n"); 
		query.append("	 , N1ST_CMNC_AMDT_SEQ		   = @[amdt_seq]" ).append("\n"); 
		query.append(" WHERE TRF_PFX_CD		   		   = @[trf_pfx_cd]" ).append("\n"); 
		query.append("   AND TRF_NO                      = @[trf_no]" ).append("\n"); 
		query.append("   AND TRF_INLND_SEQ               = @[trf_inlnd_seq]" ).append("\n"); 
		query.append("   AND AMDT_SEQ                    = @[amdt_seq]" ).append("\n"); 
		query.append("   AND N1ST_CMNC_AMDT_SEQ          <> @[amdt_seq]" ).append("\n"); 

	}
}