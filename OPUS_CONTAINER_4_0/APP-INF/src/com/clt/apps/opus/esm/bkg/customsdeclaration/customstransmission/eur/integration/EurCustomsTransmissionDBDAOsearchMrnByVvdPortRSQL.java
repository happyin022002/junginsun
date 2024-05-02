/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EurCustomsTransmissionDBDAOsearchMrnByVvdPortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.10.12 경종윤
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kyoung Jong Yun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EurCustomsTransmissionDBDAOsearchMrnByVvdPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * mrn_no 를 조회한다.
	  * </pre>
	  */
	public EurCustomsTransmissionDBDAOsearchMrnByVvdPortRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.integration ").append("\n"); 
		query.append("FileName : EurCustomsTransmissionDBDAOsearchMrnByVvdPortRSQL").append("\n"); 
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
		query.append("SELECT MRN_NO||NVL(MRN_CHK_NO, ' ') MRN_NO" ).append("\n"); 
		query.append("FROM BKG_CSTMS_KR_MF_REF_NO" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("and VSL_CD       = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO   = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD   = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("and IO_BND_CD    = DECODE(@[bnd_cd], 'O', 'O', 'I')" ).append("\n"); 

	}
}