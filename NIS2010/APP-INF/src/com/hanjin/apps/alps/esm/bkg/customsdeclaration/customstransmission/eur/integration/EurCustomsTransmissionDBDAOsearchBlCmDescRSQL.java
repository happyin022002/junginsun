/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EurCustomsTransmissionDBDAOsearchBlCmDescRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.10.13 경종윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kyoung Jong Yun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EurCustomsTransmissionDBDAOsearchBlCmDescRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CM Desc 정보를 조회한다.
	  * </pre>
	  */
	public EurCustomsTransmissionDBDAOsearchBlCmDescRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.integration ").append("\n"); 
		query.append("FileName : EurCustomsTransmissionDBDAOsearchBlCmDescRSQL").append("\n"); 
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
		query.append("SELECT  Translate(NVL(CSTMS_DESC,' '),chr(13)||chr(10), ' ') CMDESC" ).append("\n"); 
		query.append(",'' LOCAL_IPI" ).append("\n"); 
		query.append(",'' EQREL" ).append("\n"); 
		query.append(",'' EQPICKDT" ).append("\n"); 
		query.append(",'' EQRTN" ).append("\n"); 
		query.append("FROM  BKG_BL_DOC" ).append("\n"); 
		query.append("WHERE  BKG_NO  =   @[bkg_no]" ).append("\n"); 

	}
}